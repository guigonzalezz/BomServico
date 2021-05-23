package com.bomservico.bd.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



import com.bomservico.bd.util.Conexao;
import com.bomservico.model.Anuncio;
import com.bomservico.model.Usuario;

public class AnuncioDao {

	public boolean salvar(Anuncio a) {
		String sql = "insert into anuncio (descricao, tipo_servico_id, titulo, user_id) values ('$1','$2','$3','$4')";
		sql = sql.replace("$1", a.getDescricao());
		sql = sql.replace("$2", Long.toString(a.getTipo_servico().getId()));
		sql = sql.replace("$3", a.getTitulo());
		sql = sql.replace("$4", Long.toString(a.getUsuario().getId()));

		Conexao con = new Conexao();
		boolean flag = con.manipular(sql);
		con.fecharConexao();
		return flag;
	}

	public boolean alterar(Anuncio a) {
		String sql = "update anuncio set descricao='$1', titulo='$2', tipo_servico_id='$3' where id=" + a.getId();
		sql = sql.replace("$1", a.getDescricao());
		sql = sql.replace("$2", a.getTitulo());
		sql = sql.replace("$3", Long.toString(a.getTipo_servico().getId()));
		Conexao con = new Conexao();
		boolean flag = con.manipular(sql);
		con.fecharConexao();
		return flag;
	}

	public boolean apagar(int id) {
		Conexao con = new Conexao();
		boolean flag = con.manipular("delete from anuncio where id=" + id);
		con.fecharConexao();
		return flag;
	}

	public Anuncio buscarPorId(Long id) {
		Anuncio c = null;
		String sql = "select * from anuncio where id=" + id;
		Conexao con = new Conexao();
		ResultSet rs = con.consultar(sql);
		try {
			if (rs.next())
				c = new Anuncio(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"),
						new UsuarioDao().getUsuario(rs.getInt("user_id")),
						new TipoServicoDao().getServico(rs.getInt("tipo_servico_id")));
		} catch (Exception e) {
			System.out.println(e);
		}
		con.fecharConexao();
		return c;
	}

	public List<Anuncio> buscarTodos() {
		ArrayList<Anuncio> lista = new ArrayList();
		Anuncio c = null;
		String sql = "select * from anuncio";
		Conexao con = new Conexao();
		ResultSet rs = con.consultar(sql);

		try {
			while (rs.next())
				lista.add(new Anuncio(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"),
						new UsuarioDao().getUsuario(rs.getInt("user_id")),
						new TipoServicoDao().getServico(rs.getInt("tipo_servico_id"))));
		} catch (Exception e) {
			System.out.println(e);
		}
		con.fecharConexao();
		return lista;
	}

	public List<Anuncio> buscarAnunciosPorTipoServico(Long id) {
		ArrayList<Anuncio> lista = new ArrayList();
		Anuncio c = null;
		String sql = "select * from anuncio where anuncio.tipo_servico_id=" + id;
		Conexao con = new Conexao();
		ResultSet rs = con.consultar(sql);
		try {
			while (rs.next())
				lista.add(new Anuncio(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"),
						new UsuarioDao().getUsuario(rs.getInt("user_id")),
						new TipoServicoDao().getServico(rs.getInt("tipo_servico_id"))));
		} catch (Exception e) {
			System.out.println(e);
		}
		con.fecharConexao();
		return lista;
	}

	public List<Anuncio> buscarAnunciosDoUsuario(Usuario usuario) {
		ArrayList<Anuncio> lista = new ArrayList();
		Anuncio c = null;
		String sql = "select * from anuncio where anuncio.user_id=" + usuario.getId();
		Conexao con = new Conexao();
		ResultSet rs = con.consultar(sql);
		try {
			while (rs.next())
				lista.add(new Anuncio(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"),
						new UsuarioDao().getUsuario(rs.getInt("user_id")),
						new TipoServicoDao().getServico(rs.getInt("tipo_servico_id"))));
		} catch (Exception e) {
			System.out.println(e);
		}
		con.fecharConexao();
		return lista;
	}
	
	public ArrayList <Anuncio> getAnuncio(String filtro)
    {   ArrayList <Anuncio> lista=new ArrayList();
        String sql="select * from anuncio";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by id ASC";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
        	while (rs.next())
				lista.add(new Anuncio(rs.getLong("id"), rs.getString("titulo"), rs.getString("descricao"),
						new UsuarioDao().getUsuario(rs.getInt("user_id")),
						new TipoServicoDao().getServico(rs.getInt("tipo_servico_id"))));
		}
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }

}
