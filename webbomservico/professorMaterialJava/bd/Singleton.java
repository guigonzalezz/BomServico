package com.example.demo.bd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entity.Pessoa;

public class Singleton 
{   public static int nextID=1;
    public static List <Pessoa> equipe=new ArrayList(
    	Arrays.asList(
        new Pessoa(nextID++,"Bart Simpsons","bart@springfield.com","estudante"),
        new Pessoa(nextID++,"Freddy Krueger","fred@elmstreet.com","assassino"),
        new Pessoa(nextID++,"Rick Grimes","rick@atlanta.com","policial"),
        new Pessoa(nextID++,"Peter Park","peter@spiderman.com","reporter")));
}

