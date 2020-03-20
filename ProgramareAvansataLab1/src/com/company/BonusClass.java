package com.company;

import java.util.*;

public class BonusClass {
    int n, k;
    boolean graph[][];
    boolean viz[];
    String alphabet;
    String words [];
    public boolean run(String[] args)
    {
        if(args.length<3)
        {
            System.out.println("Invalid arguments!");
            return false;
        }
        try {
            n = Integer.parseInt(args[0]);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid arguments!");
            return false;
        }
        try {
            k = Integer.parseInt(args[1]);
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid arguments!");
            return false;
        }
        alphabet = "";
        for(int i = 2; i<args.length;i++) {
            if (args[i].length() == 1 && Character.isLetter(args[i].charAt(0))) {
                alphabet = alphabet + args[i].charAt(0);
            } else {
                System.out.println("Invalid arguments!");
                return false;
            }
        }
            words = new String[n];

            for (int i = 0; i < n; i++) {
                words[i] = "";
                for (int j = 0; j < k; j++) {
                    int pos = (int) (Math.random() * alphabet.length());
                    words[i] = words[i] + alphabet.charAt(pos);
                }

            }
            displayAlphabet();
            graph  = new boolean[n][n];
            initMatrix();
            displayMartix();
            System.out.println("The node with most neighbours is " + getMostNeighbors());
            System.out.println("The node with least neighbours is " + getLeastNeighbors());
            getComponents();
        return true;
    }
    void DFS(int node)
    {
        System.out.println(words[node]);
        viz[node] = true;
        for(int i  = 0; i< n; i++)
        {
            if(graph[node][i] && !viz[i])
            {
                DFS(i);
            }
        }
    }
    public void getComponents()
    {
        viz = new boolean[n];
        for(int i = 0; i < n; i++)
        {
            viz[i] = false;
        }
        int nrComponents = 0;
        for(int i = 0; i < n; i++)
        {
            if(!viz[i])
            {
                nrComponents++;
                System.out.println("Component " + nrComponents + ":");
                DFS(i);
            }

        }
        System.out.println("We have " + nrComponents + " components");
    }
    public void displayAlphabet()
    {
        for(int i = 0 ; i < words.length; i++)
        {
            System.out.println(words[i]);
        }
    }
    public void initMatrix()
    {
        for(int i = 0; i<n-1;i++)
            for(int j  = i + 1; j < n; j++)
            {
                if(isAdiacent(i, j))
                {
                    graph[i][j] = true;
                    graph[j][i] = true;
                }
                else
                {
                    graph[i][j] = false;
                    graph[j][i] = false;
                }
            }
    }
    public boolean isAdiacent(int x, int y)
    {
        for(int i  = 0; i<words[x].length(); i++)
        {
            if(words[y].indexOf(words[x].charAt(i))!=-1)
            {
                return true;
            }
        }
        return false;
    }
    public void displayMartix()
    {
        for(int i = 0; i < n; i++)
        {
            for(int j  =0; j < n; j++)
            {
                System.out.print((graph[i][j] ? 1 : 0));
            }
            System.out.println();
        }
    }
    public int getMostNeighbors()
    {
        int maxN = getNeighbors(0);
        int maxI = 0;
        for(int i = 1; i< n; i++)
        {
            int res = getNeighbors(i);
            if(res > maxN)
            {
                maxN = res;
                maxI = i;
            }
        }
        return maxI;
    }
    public int getLeastNeighbors()
    {
        int minN = getNeighbors(0);
        int minI = 0;
        for(int i = 1; i< n; i++)
        {
            int res = getNeighbors(i);
            if(res < minN)
            {
                minN = res;
                minI = i;
            }
        }
        return minI;
    }
    public int getNeighbors(int x)
    {
        int neighbours = 0;
        for(int i = 0; i< n; i++)
            if(graph[x][i])
            {
                neighbours++;
            }
        return neighbours;
    }
}
