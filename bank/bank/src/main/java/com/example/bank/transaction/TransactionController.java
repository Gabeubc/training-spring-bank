package com.example.bank.transaction;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path ="api/v1/transaction")
public class TransactionController {

	final private TransactionService transactionService;

	@Autowired
	public TransactionController(TransactionService transactionService) {
		super();
		this.transactionService = transactionService;
	}
	
	@GetMapping
	public List<Transaction> getTransactions()
	{
		return this.transactionService.getTransactions();
	}
	
	@GetMapping(params="transactionID")
	public Transaction getTransaction(@RequestParam(name ="transactionID") String transactionID) throws Exception
	{
		return this.transactionService.getTransaction(transactionID);
	}
	
	@PostMapping
	public String createTransaction(Transaction transaction)throws Exception
	{
		return this.transactionService.createTransaction(transaction);
	}
	
}
