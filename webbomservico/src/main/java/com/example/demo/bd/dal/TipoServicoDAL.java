package com.example.demo.bd.dal;

import java.sql.ResultSet;
import java.util.ArrayList;

import com.example.demo.bd.entidade.TIpoServico;
import com.example.demo.bd.util.Conexao;

public class TipoServicoDAL {
	public boolean salvar (TIpoServico a)
    {
        String sql="insert into tipo_servico (nome) values ('$1')";
        sql=sql.replace("$1",a.getNome());
        
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                              
    }
	
    public boolean alterar (TIpoServico a)
    {
        String sql="update tipo_servico set nome='$1' where id="+a.getId();
        sql=sql.replace("$1",a.getNome());
        Conexao con=new Conexao();
        boolean flag=con.manipular(sql);
        con.fecharConexao();
        return flag;                       
    }
    
    public boolean apagar(int id)
    {
        Conexao con=new Conexao();
        boolean flag=con.manipular("delete from tipo_servico where id="+id);
        con.fecharConexao();
        return flag;                      
    }
    
    public TIpoServico getServico(int cod)
    {   TIpoServico c=null;
        String sql="select * from tipo_servico where id="+cod;
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          if (rs.next())
            c=new TIpoServico(rs.getInt("id"),rs.getString("nome"));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return c;
    }
    
    public ArrayList <TIpoServico> getServico(String filtro)
    {   ArrayList <TIpoServico> lista=new ArrayList();
        String sql="select * from tipo_servico";
        if (!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by id ASC";
        Conexao con=new Conexao();
        ResultSet rs = con.consultar(sql);
        try
        {
          while(rs.next())
             lista.add(
            		 new TIpoServico(rs.getInt("id"),rs.getString("nome")));
        }
        catch(Exception e){System.out.println(e);}
        con.fecharConexao();
        return lista;
    }
}
