package com.bomservico.bd.dao;

import java.sql.ResultSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bomservico.bd.util.Conexao;
import com.bomservico.model.Anuncio;
import com.bomservico.model.TipoServico;
import com.bomservico.model.Usuario;


public class UsuarioDao {


	public Usuario buscarPorUsername(String username) {
		Usuario c = null;
		String sql = "select * from user where user.login=" + username;
		Conexao con = new Conexao();
		ResultSet rs = con.consultar(sql);
		try {
			if (rs.next())
				c = new Usuario(
						rs.getLong("id"),
						rs.getString("nome"),
						rs.getString("login"),
						rs.getString("senha")
						);
		} catch (Exception e) {
			System.out.println(e);
		}
		con.fecharConexao();
		return c;
	}
	
	public Usuario getUsuario(int id) {
		Usuario c=null;
        String sql="select * from user where id="+id;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            c=new Usuario(
            		rs.getLong("id"),
            		rs.getString("nome"),
            		rs.getString("login"),
            		rs.getString("senha")
            		);
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return c;
	}
	
	public boolean deletar(Long id) {
		Conexao con = new Conexao();
		boolean flag = con.manipular("delete from user where id=" + id);
		con.fecharConexao();
		return flag;
	}

}
