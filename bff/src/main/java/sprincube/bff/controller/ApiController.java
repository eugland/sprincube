package sprincube.bff.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import sprincube.bff.client.AccountClient;
import sprincube.bff.client.FriendClient;
import sprincube.bff.domain.Account;
import sprincube.bff.domain.Friend;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final Logger logger = LoggerFactory.getLogger(ApiController.class);
    private AccountClient accountClient;
    private FriendClient friendClient;

    public ApiController(AccountClient accountClient, FriendClient friendClient) {
        this.accountClient = accountClient;
        this.friendClient = friendClient;
    }

    @GetMapping("/account")
    List<Account> findAccounts() {
        return accountClient.findAccount();
    }

    @GetMapping("/account/{id}")
    List<Account> findAccount(@PathVariable int id) {
        return accountClient.findAccount(id);
    }

    @GetMapping("/friend")
    Iterable<Friend> findFriend() {
        return friendClient.findFriend();
    }

    @GetMapping("/friend/{id}")
    Iterable<Friend> findFriend(@PathVariable String id) {
        return friendClient.findFriend(id);
    }
}
