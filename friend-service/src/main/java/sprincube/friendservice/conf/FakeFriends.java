package sprincube.friendservice.conf;

import sprincube.friendservice.domain.Friend;

import java.util.concurrent.ThreadLocalRandom;

public class FakeFriends {
    static int one = 0;
    public static Friend make(){
        int number = ThreadLocalRandom.current().nextInt(0,5);
        one++;
        return new Friend(
                "FRIEND" + one, number
                );

    }
}
