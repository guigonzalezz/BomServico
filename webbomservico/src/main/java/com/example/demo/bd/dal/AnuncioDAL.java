package com.example.demo.bd.dal;

import com.example.demo.bd.entidade.Anuncio;
import com.example.demo.bd.util.Conexao;
import java.sql.ResultSet;
import java.util.ArrayList;

public class AnuncioDAL {
	public boolean salvar (Anuncio a)
    {
        String sql="insert into anuncio (descricao, tipo_servico_id, titulo, user_id) values ('$1','$2','$3','$4')";
        sql=sql.replace("$1",a.getDescricao());
        sql=sql.replace("$2",Integer.toString(a.getTipo_servico_id()));
        sql=sql.replace("$3",a.getTitulo());
        sql=sql.replace("$4",Integer.toString(a.getUser_id()));
        
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
	
    public boolean alterar (Anuncio a)
    {
        String sql="update anuncio set descricao='$1', titulo='$2', tipo_servico_id='$3' where id="+a.getId();
        sql=sql.replace("$1",a.getDescricao());
        sql=sql.replace("$2",a.getTitulo());
        sql=sql.replace("$3",Integer.toString(a.getTipo_servico_id()));
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from anuncio where id="+id);
        con.fecharConexao();
        return flag;                      
    }
    
    public Anuncio getAnuncio(int cod)
    {   Anuncio c=null;
        String sql="select * from anuncio where id="+cod;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            c=new Anuncio(rs.getInt("id"),rs.getInt("tipo_servico_id"),rs.getInt("user_id"),rs.getString("descricao"),rs.getString("titulo"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return c;
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
          while(rs.next())
             lista.add(
            		 new Anuncio(rs.getInt("id"),rs.getInt("tipo_servico_id"),rs.getInt("user_id"),rs.getString("descricao"),rs.getString("titulo")));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
}
