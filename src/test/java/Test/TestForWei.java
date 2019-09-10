package Test;

import oracle.jrockit.jfr.openmbean.ProducerDescriptorType;

import java.util.ArrayList;

public class TestForWei {

    public static void main(String[] args) {

        ArrayList<ProducerDescriptorType> mallProducts = new ArrayList<>();
        int i = mallProducts.size() / 20;

        if(i>=1){
            ArrayList<ProducerDescriptorType> products = new ArrayList<>();

            int j=0;
            for (ProducerDescriptorType mallProduct : mallProducts) {
                if(products.size()==20 || mallProducts.size()-1==j){
                    //发送请求
                    String ids=getProducts(products);
                    //HznzHttpUtils.sendPostNzw("");
                     //清空集合
                    products.clear();
                    continue;
                }
                products.add(mallProduct);
                j++;
            }

        }

        //直接请求
    }

    private static String getProducts(ArrayList<ProducerDescriptorType> products) {
        return "1,2";
    }
}
