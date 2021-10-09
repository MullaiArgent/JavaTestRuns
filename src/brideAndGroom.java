import java.util.*;

class Main{
    static Integer no_of_neighbours(List<Integer> address, List<List<Integer>> houses){
        int ans = 0;
        try{
            if ((address.get(0) - 1 >= 0) && (address.get(1) - 1) >= 0) {
                ans = ans + (houses.get(address.get(0) - 1).get(address.get(1) - 1));
            }
        }catch (Exception ignored){}

        try{
            if (address.get(0) - 1 >= 0){
                ans = ans + (houses.get(address.get(0) - 1).get(address.get(1)));
            }
        }catch (Exception ignored){}

        try{
            if (address.get(0) - 1 >= 0){
                ans = ans + (houses.get(address.get(0) - 1).get(address.get(1) + 1));
            }
        }catch (Exception ignored){}

        try{
            if (address.get(1) - 1 >= 0){
                ans = ans + (houses.get(address.get(0)).get(address.get(1) - 1));
            }
        }catch (Exception ignored){}

        try{
                ans = ans + (houses.get(address.get(0)).get(address.get(1) + 1));
        }catch (Exception ignored){}
        try{
            if (address.get(1) - 1 >= 0) {
                ans = ans + (houses.get(address.get(0) + 1).get(address.get(1) - 1));
            }
        }catch (Exception ignored){}
        try{

                ans = ans + (houses.get(address.get(0) + 1).get(address.get(1)));
        }catch (Exception ignored){}
        try{
                ans = ans + (houses.get(address.get(0) + 1).get(address.get(1) + 1));
        }catch (Exception ignored){}

        return ans;
    }
    static List<Integer> toList(String str){
        List<Integer> list = new ArrayList<>();
        for (String s : str.split("\\s")){
            list.add(Integer.parseInt(s));
        }
        return list;
    }
    public static  void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String str1 = scan.nextLine();
        List<Integer> lineOne = toList(str1);

        String str2 = scan.nextLine();
        List<Integer> listTwo = toList(str2);

        String str3 = scan.nextLine();
        List<Integer> listThree = toList(str3);

        List<List<Integer>> houses = new ArrayList<>();
        houses.add(listTwo);
        houses.add(listThree);


        Map<List<Integer>, Integer> neighbours = new Hashtable<>();
        for (int i = 0; i < lineOne.get(0); i++){
            for (int j = 0; j < lineOne.get(1); j++){
                if (houses.get(i).get(j).equals(1)) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    neighbours.put(temp, no_of_neighbours(temp, houses));
                }
            }
        }
        int max_neighbours = -999999999;
        for (Map.Entry<List<Integer>, Integer> i : neighbours.entrySet()){
            max_neighbours = Math.max(max_neighbours, i.getValue());
        }

        List<List<Integer>> finals = new ArrayList<>();
        for (Map.Entry<List<Integer>, Integer> i : neighbours.entrySet()){
            if (i.getValue().equals(max_neighbours)){
                finals.add(i.getKey());
            }
        }
        int ans = 9999999;
        int a = 0;
        int b = 0;
        for (List<Integer> list : finals){
            int temp = 0;
            for(Integer i : list){
                temp += i;
            }
            if (ans > temp){
                ans = temp;
                a = list.get(0) + 1;
                b = list.get(1) + 1;
            }
        }
        System.out.println(a + ":" + b + ":" + max_neighbours);
    }
}
