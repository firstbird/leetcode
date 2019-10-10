package com.mzl.map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CanFinish {
    static int WHITE = 1;
    static int GRAY = 2;// 表示开始点
    static int BLACK = 3;// 表示节点完成遍历

    Map<Integer, List<Integer>> adjList;// key: src,  value:

    Map<Integer, Integer> color;

    boolean isPossible;

    private void init(int numCourses) {
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            this.color.put(i, WHITE);
        }
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0 || numCourses == 0) {
            return false;
        }

        init(numCourses);
        // Create the adjacency list representation of the graph
        // 创建每个点的邻接点列表，代表图
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            // 存储src节点及相关的邻接点
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }
        for (int i = 0; i < numCourses; i++) {
            for(Integer neighbour: adjList.getOrDefault(i, new ArrayList<Integer>())) {
                if (this.color.get(i) == WHITE) {
                    this.dfs(i);
                }
            }
        }
        return isPossible;

    }

    private void dfs(int node) {
       if (!this.isPossible) {
            return;
       }
       this.color.put(node, GRAY);

       for (Integer neighbour : adjList.getOrDefault(node, new ArrayList<Integer>())) {
          if (color.get(neighbour) == WHITE) {
              dfs(neighbour);
          } else if (color.get(neighbour) == GRAY) {
              isPossible = false;
              return;
          }
       }
       this.color.put(node, BLACK);
    }
}
