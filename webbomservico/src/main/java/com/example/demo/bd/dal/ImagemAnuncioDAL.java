package com.example.demo.bd.dal;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.bd.entidade.ImagemAnuncio;
import com.example.demo.bd.entidade.TIpoServico;
import com.example.demo.bd.util.Conexao;

public class ImagemAnuncioDAL {
	public boolean salvar (ImagemAnuncio a)
    {
        String sql="insert into imagem_anuncio (path, anuncio_id) values ('$1', '$2')";
        sql=sql.replace("$1",a.getPath());
        sql=sql.replace("$2",Integer.toString(a.getAnuncioId()));
        
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
	
    public boolean alterar (ImagemAnuncio a)
    {
        String sql="update imagem_anuncio set path='$1', anuncio_id = '$2' where id="+a.getId();
        sql=sql.replace("$1",a.getPath());
        sql=sql.replace("$2",Integer.toString(a.getAnuncioId()));
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from imagem_anuncio where id="+id);
        con.fecharConexao();
        return flag;                      
    }
    
    public ImagemAnuncio getAnuncio(int cod)
    {   ImagemAnuncio c=null;
        String sql="select * from imagem_anuncio where id="+cod;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            c=new ImagemAnuncio(rs.getInt("id"),rs.getInt("anuncio_id"),rs.getString("path"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return c;
    }
    
    public ArrayList <ImagemAnuncio> getAnuncio(String filtro)
    {   ArrayList <ImagemAnuncio> lista=new ArrayList();
        String sql="select * from imagem_anuncio";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by id ASC";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
            		 new ImagemAnuncio(rs.getInt("id"),rs.getInt("anuncio_id"),rs.getString("path")));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
}
