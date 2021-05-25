package com.example.calculator;

import java.util.Deque;
import java.util.LinkedList;

public class historico
{
    private Deque<String> filaHistorico;

    public historico()
    {
        filaHistorico = new LinkedList<String>();
        }

    public String getHistorico()
    {
        String valorHistorico = "";
        for (String s : filaHistorico)
        {
            valorHistorico += s;
        }
        return valorHistorico;
    }

    public void limpar()
    {
        filaHistorico.clear();
    }

    public void adicionarValor(String entrada)
    {
        filaHistorico.add(entrada + "\n");

        while ( filaHistorico.size() > 15)
        {
            filaHistorico.removeFirst();
        }
    }

    public void adicionarSeparador()
    {
        filaHistorico.add("____________________\n");
    }
}
