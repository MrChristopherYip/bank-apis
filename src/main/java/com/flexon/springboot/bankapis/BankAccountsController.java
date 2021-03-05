package com.flexon.springboot.bankapis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/accounts")
public class BankAccountsController {
    @Autowired
    private BankAccountsDAO bankAccounts = new BankAccountsDAO();

    @PostMapping(path = "/create")
    public String createAccount(@RequestBody BankAccount account) {
        return "New account number: " + bankAccounts.createAccount(account);
    }

    @GetMapping(path = "/all")
    public ArrayList<BankAccount> getAllAccounts() {
        return bankAccounts.getAllAccounts();
    }

    @GetMapping(path = "/get{accountNum}")
    public BankAccount getAccount(@PathVariable int accountNum) {
        return bankAccounts.getAccount(accountNum);
    }

    @PutMapping(path = "/update")
    public boolean updateAccount(@RequestBody BankAccount account) {
        return bankAccounts.updateAccount(account);
    }

    @DeleteMapping(path = "/delete{accountNum}")
    public boolean deleteAccount(@PathVariable int accountNum) {
        return bankAccounts.deleteAccount(accountNum);
    }
}
