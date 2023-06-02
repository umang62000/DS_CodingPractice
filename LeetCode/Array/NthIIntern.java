public class NthIIntern {
    public static int labelans(int input1,int input2 ){
        int label=0;
        boolean flag=true;
        for(int i=0;i<50;i++){
            if(!flag){
                break;
            }
            for(int j=1;j<input1;j++){
                int pwd=(5000*j)+(5000*i);
                if(pwd==input2){
                    label=j;
                    flag=false;
                    break;
                }
            }
        }
        return label;
    }
    public static void main(String[] args) {
        System.out.println(labelans(10,25003));
    }
}
