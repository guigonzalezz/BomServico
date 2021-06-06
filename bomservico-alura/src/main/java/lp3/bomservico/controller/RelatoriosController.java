package lp3.bomservico.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lp3.bomservico.dto.RequisicaoRelatorioAnuncio;
import lp3.bomservico.model.Anuncio;
import lp3.bomservico.service.AnuncioService;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
public class RelatoriosController {
	@Autowired
    private ResourceLoader resourceLoader;
	
	@Autowired
    private AnuncioService anuncioService;
    
    @RequestMapping(value="/geraRelatorio", method=RequestMethod.GET)
    public ResponseEntity<byte[]> geraRelatorio () throws IOException   
    {
        // path referencia o caminho relativo (realpath) para a pasta que se encontra os .jasper
        String path = resourceLoader.getResource("classpath:reports/anuncios2.jasper").getURI().getPath();
        byte[] contents = gerarRelatorioPDF("SELECT a.id as id, a.descricao as descricao, a.titulo as titulo, c.nome as categoria, a.user_username as user FROM anuncio as a INNER JOIN tipo_servico as c ON a.tipo_servico_id = c.id", path);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        //headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
        ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
        return response;
    }
        
    private byte[] gerarRelatorioPDF(String sql, String relat)
    {   byte[] pdf;
        try { //sql para obter os dados para o relatorio
            JasperPrint jasperprint=null;
//            ResultSet rs = new Conexao().consultar(sql);
            List<Anuncio> rs = anuncioService.relatorio();
            List<RequisicaoRelatorioAnuncio> rel = new ArrayList<>();
            rs.forEach(item -> {
            	RequisicaoRelatorioAnuncio novo = new RequisicaoRelatorioAnuncio();
            	novo.setId(item.getId());
            	novo.setDescricao(item.getDescricao());
            	novo.setNome(item.getTipo_servico().getNome());
            	novo.setTitulo(item.getTitulo());
            	novo.setUsername(item.getUsuario().getUsername());
            	rel.add(novo);
            });
            JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(rel);
            jasperprint = JasperFillManager.fillReport(relat, null, ds);
            pdf=JasperExportManager.exportReportToPdf(jasperprint);

        } catch (JRException erro) {
            pdf=null;
        }
        return pdf;
    }
}
