package com.banxian.algorithm.prim;

import java.util.Arrays;

/**
 * Created by liugh on 2020/10/30.
 */
public class PrimAlgorithm {



    public static void main(String[] args) {
        //测试看看图是否创建ok
        char[] data = new char[]{'A','B','C','D','E'};
        //邻接矩阵的关系使用二维数组表示,10000这个大数，表示两个点不联通
        int [][]weight=new int[][]{
                {100,5,100,5,7},
                {5,100,4,100,3},
                {100,4,100,8,2},
                {5,100,8,100,6},
                {7,3,2,6,100}};

        //创建MGraph对象
        MGraph graph = new MGraph(data);
        //创建一个MinTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, data, weight);
        //输出
        minTree.showGraph(graph);
        //测试普利姆算法
        minTree.prim2(graph, 1);//
    }

}

//创建最小生成树->村庄的图
class MinTree {
    public void prim2(MGraph graph, int v) {
        //标记顶点是否被访问过
        int [] flag = new int[graph.data.length];
        int  weight =100;
        //表示第两个顶点
        int h1 =-1,h2 =-1;
        flag[v] =1;
        int sum=0;
        for (int z = 0; z < graph.data.length -1; z++) {//有len-1条边

            //这个是确定每一次生成的子图 ，和哪个结点的距离最近, i结点表示被访问过的结点 j结点表示还没有访问过的结点
            for (int i = 0; i < graph.data.length; i++) {
                for (int j = 0; j < graph.data.length; j++) {
                    if(flag[i] ==1 && flag[j] ==0 ){
                        weight = graph.weight[i][j];
                        sum+=weight;
                        h1=i;
                        h2=j;
                    }
                }
                if(h1 !=-1 && h2 != -1){
                    System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + weight);
                }
            }
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + weight);
            weight=100;
            flag[h2] = 1;
        }
    }



    //创建图的邻接矩阵
    /**
     *
     * @param graph 图对象
     * @param data 图的各个顶点的值
     * @param weight 图的邻接矩阵
     */
    public void createGraph(MGraph graph, char data[], int[][] weight) {
        int i, j;
        for(i = 0; i < data.length; i++) {//顶点
            graph.data[i] = data[i];
            for(j = 0; j < data.length; j++) {
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    //显示图的邻接矩阵
    public void showGraph(MGraph graph) {
        for(int[] link: graph.weight) {
            System.out.println(Arrays.toString(link));
        }
    }






    //编写prim算法，得到最小生成树
    /**
     *
     * @param graph 图
     * @param v 表示从图的第几个顶点开始生成'A'->0 'B'->1...
     */
    public void prim(MGraph graph, int v) {
        //visited[] 标记结点(顶点)是否被访问过
        int visited[] = new int[graph.data.length];
        //visited[] 默认元素的值都是0, 表示没有访问过
//		for(int i =0; i <graph.verxs; i++) {
//			visited[i] = 0;
//		}

        //把当前这个结点标记为已访问
        visited[v] = 1;
        //h1 和 h2 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000; //将 minWeight 初始成一个大数，后面在遍历过程中，会被替换
        for(int k = 1; k < graph.data.length; k++) {//因为有 graph.verxs顶点，普利姆算法结束后，有 graph.verxs-1边

            //这个是确定每一次生成的子图 ，和哪个结点的距离最近
            for(int i = 0; i < graph.data.length; i++) {// i结点表示被访问过的结点
                for(int j = 0; j< graph.data.length;j++) {//j结点表示还没有访问过的结点
                    if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
                        //替换minWeight(寻找已经访问过的结点和未访问过的结点间的权值最小的边)
                        minWeight = graph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            //找到一条边是最小
            System.out.println("边<" + graph.data[h1] + "," + graph.data[h2] + "> 权值:" + minWeight);
            //将当前这个结点标记为已经访问
            visited[h2] = 1;
            //minWeight 重新设置为最大值 10000
            minWeight = 10000;
        }

    }
}

class MGraph {
    char[] data;//存放结点数据
    int[][] weight; //存放边，就是我们的邻接矩阵

    public MGraph(char[] data) {
        this.data = data;
        weight = new int[data.length][data.length];
    }
}
