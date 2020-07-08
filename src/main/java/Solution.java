import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {


    /**
     * Comments - for both solution one and two.
     * commonList.removeIf(common -> !(firstList.contains(common) && secondList.contains(common)
     *                 && thirdList.contains(common)));
     *        Here code has to go through all three sub list to check string is in list.
     *        If use !firstList.contains(common) || !secondList.contains(common) || thirdList.contains(common)
     *        it will reduce no of loops.
     *  firstList.removeIf(first -> newSecondList.contains(first) || newThirdList.contains(first));
     *        Here you dont want to check with other two list. you can check with common List as
     *            firstList.removeIf(first -> commonList.contains(first))
     */


    public static void main(String[] args) {
        Solution.solutionOne();
        Solution.solutionTwo();
    }

    public static void solutionTwo() {
        List<String> commonList = new ArrayList<>(Arrays.asList("first", "second", "third", "fourth"));

        List<String> firstList = new ArrayList<>(Arrays.asList("first", "second", "fourth"));
        List<String> secondList = new ArrayList<>(Arrays.asList("first", "third", "fourth"));
        List<String> thirdList = new ArrayList<>(Arrays.asList("first", "fourth", "fifth"));

        List<String> finalSecondList = secondList;
        List<String> finalFirstList = firstList;
        List<String> finalThirdList = thirdList;
        List<String> finalCommonList = commonList;

        firstList = firstList.stream()
                .filter(value -> finalCommonList.contains(value) && !finalSecondList.contains(value) || !finalFirstList.contains(value)).collect(Collectors.toList());

        secondList = secondList.stream()
                .filter(value -> finalCommonList.contains(value) && !finalFirstList.contains(value) || !finalThirdList.contains(value)).collect(Collectors.toList());

        thirdList = thirdList.stream()
                .filter(value -> finalCommonList.contains(value) && !finalFirstList.contains(value) || !finalSecondList.contains(value)).collect(Collectors.toList());

        commonList = commonList.stream().filter(value -> finalFirstList.contains(value) && finalSecondList.contains(value) && finalThirdList.contains(value)).collect(Collectors.toList());

        System.out.println(firstList);
        System.out.println(secondList);
        System.out.println(thirdList);
        System.out.println(commonList);



    }

    public static void solutionOne() {
        List<String> commonList = new ArrayList<>(Arrays.asList("first", "second", "third", "fourth"));

        List<String> firstList = new ArrayList<>(Arrays.asList("first", "second", "fourth"));
        List<String> secondList = new ArrayList<>(Arrays.asList("first", "third", "fourth"));
        List<String> thirdList = new ArrayList<>(Arrays.asList("first", "fourth", "fifth"));

        List<String> newFirstList = new ArrayList<>(firstList);
        List<String> newSecondList = new ArrayList<>(secondList);
        List<String> newThirdList = new ArrayList<>(thirdList);

        commonList.removeIf(common -> !(firstList.contains(common) && secondList.contains(common)
                && thirdList.contains(common)));
//        firstList.removeIf(first -> commonList.contains(first));
        firstList.removeIf(first -> newSecondList.contains(first) || newThirdList.contains(first));
        secondList.removeIf(second -> newFirstList.contains(second) || newThirdList.contains(second));
        thirdList.removeIf(third -> newFirstList.contains(third) || newSecondList.contains(third));

        System.out.println("CommonList = " + commonList);
        System.out.println("firstList = " + firstList);
        System.out.println("secondList = " + secondList);
        System.out.println("thirdList = " + thirdList);

    }
}
