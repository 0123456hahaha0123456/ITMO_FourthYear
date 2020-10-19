package domain;
import java.io.*;
import java.util.*;
import java.util.ArrayDeque;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine().trim());
        char[][] dir = new char[N][N];
        for(int i_dir = 0; i_dir < N; i_dir++)
        {
            String[] arr_dir = br.readLine().split(" ");
            for(int j_dir = 0; j_dir < arr_dir.length; j_dir++)
            {
                dir[i_dir][j_dir] = arr_dir[j_dir].charAt(0);
            }
        }
        String[] line = br.readLine().split(" ");
        int sx = Integer.parseInt(line[0]);
        int sy = Integer.parseInt(line[1]);
        line = br.readLine().split(" ");
        int dx = Integer.parseInt(line[0]);
        int dy = Integer.parseInt(line[1]);
        int out_ = solve(N, dir, sx, sy, dx, dy);
        System.out.println(out_);

        wr.close();
        br.close();
    }


    static boolean check(int N, int x, int y){
        return (x>=0 && x<N && y>=0 && y<N);
    }

    static int solve(int N, char[][] dir, int sx, int sy, int dx, int dy){

        int max_value = 10000000;
        //         U R D L
        int[] d = {-1,0,1,0};
        int[] c = {0,1,0,-1};
        int[][] dd = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++) dd[i][j] = max_value;
        }
        dd[sx-1][sy-1] = 0;
        ArrayDeque<Cor> queue = new ArrayDeque<Cor>();
        queue.addLast(new Cor(sx-1, sy-1));
        while(!queue.isEmpty()){
            Cor tmp = queue.poll();
            int old_x = tmp.getKey();
            int old_y = tmp.getValue();
            for(int i=0;i<4;i++){
                int new_x = old_x + d[i];
                int new_y = old_y + c[i];
                if (check(N, new_x, new_y)){
                    if (
                            ((dir[old_x][old_y] == 'L') && (i==3) && (dd[new_x][new_y] > dd[old_x][old_y])) ||
                                    ((dir[old_x][old_y] == 'U') && (i==0) && (dd[new_x][new_y] > dd[old_x][old_y])) ||
                                    ((dir[old_x][old_y] == 'R') && (i==1) && (dd[new_x][new_y] > dd[old_x][old_y])) ||
                                    ((dir[old_x][old_y] == 'D') && (i==2) && (dd[new_x][new_y] > dd[old_x][old_y]))

                    ){
                        dd[new_x][new_y] = dd[old_x][old_y];
                        queue.addLast(new Cor(new_x,new_y));
                    }else if (dd[new_x][new_y] > dd[old_x][old_y] +1){
                        dd[new_x][new_y] = dd[old_x][old_y]+1;
                        queue.addLast(new Cor(new_x,new_y));
                    }
                }
            }
        }
        return dd[dx-1][dy-1];

    }

    static class Cor{
        int key;
        int value;
        public Cor(int key, int value){
            this.key = key;
            this.value = value;
        }

        public int getKey(){
            return this.key;
        }
        public int getValue(){
            return this.value;
        }
    }
}