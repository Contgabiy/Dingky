public class practice2 {

    public static void main(String[] args) {
        Lost l1 = new Lost("cup", 06.07, "三教");
        Lost l2 = new BookLost("c++ primer", 07.12, "数图", "Stanley");
        Lost l3 = new CardLost("校园一卡通", 05.01, "风华操场", "20222554568", "计算机学院");
        Lost l4 = new Lost("cup", 05.31, "二教");
        Lost[] losts = new Lost[4];
        losts[0] = l1;
        losts[1] = l2;
        losts[2] = l3;
        losts[3] = l4;
        Solution solution = new Solution();
        solution.sortLost(losts);
        for (Lost lost : losts) {
            System.out.println(lost);
        }
        Lost[] fevers = solution.selectByKeyword(losts, "cup");
        System.out.println("-------------");
        for (Lost lost : fevers) {
            if (lost != null) {
                System.out.println(lost);
            }
        }
    }
}

class Solution {

    /**
     * 失物排序方法
     *
     * @param lostArray 待排序的失物数组
     */
    public void sortLost(Lost[] lostArray) {
        Lost temp = null;
        for (int i = 0; i < lostArray.length - 1; i++) {
            for (int j = i + 1; j < lostArray.length; j++) {
                if (lostArray[j].time > lostArray[i].time) {
                    temp = lostArray[i];
                    lostArray[i] = lostArray[j];
                    lostArray[j] = temp;
                }
            }
        }
    }

    /**
     * 按关键字搜索失物的方法，这里假设按照失物的领取地点进行搜索
     *
     * @param lostArray 失物数组
     * @param keyword   用户输入的关键字
     * @return 返回查找到的失物
     */
    public Lost[] selectByKeyword(Lost[] lostArray, String keyword) {
        Lost[] list = new Lost[lostArray.length];
        int i = 0;
        for (Lost lost : lostArray) {
            if (lost.name.equals(keyword)) {
                list[i++] = lost;
            }
        }
        return list;
    }
}

class Lost {
    public String name;
    public double time;
    public String location;

    public Lost(String name, double time, String location) {
        this.name = name;
        this.time = time;
        this.location = location;
    }

    @Override
    public String toString() {
        return "Lost{" +
                "name='" + name + '\'' +
                ", time=" + time +
                ", location='" + location + '\'' +
                '}';
    }
}

class CardLost extends Lost {
    public String studentId;//学号

    public String college;//学院

    public CardLost(String name, double time, String location, String studentId, String college) {
        super(name, time, location);
        this.studentId = studentId;
        this.college = college;
    }
}

class BookLost extends Lost {
    public String author;//作者名字

    public BookLost(String name, double time, String location, String author) {
        super(name, time, location);
        this.author = author;
    }

}
