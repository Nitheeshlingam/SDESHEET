public class BuyandSell1 {
    public static int maxProfit(int[] prices) {
        int buy = -1,maxprofit = 0;
        for(int price: prices){
            if(buy == -1) buy = price;
            else if(buy>=price) buy = price;
            else{
                int profit = price - buy;
                maxprofit = maxprofit<profit ? profit :maxprofit;
            }
        }
        return maxprofit;
    }
    public static void main(String[]args){
        int []prices = {7,6,4,3,1};
        int profit = maxProfit(prices);
        System.out.println(profit);
    }
}
