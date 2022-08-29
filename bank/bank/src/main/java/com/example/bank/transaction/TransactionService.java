package com.example.bank.transaction;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bank.user.*;


@Service
public class TransactionService {
	
	static private Integer countID=0;
	final private TransactionRepository transactionRepository;
	final private UserRepository userRepository;
	
	@Autowired
	public TransactionService(TransactionRepository transactionRepository, UserRepository userRepository)
	{
		this.transactionRepository= transactionRepository;
		this.userRepository=userRepository;
	}
	
	public List<Transaction> getTransactions()
	{
		return this.transactionRepository.findAll();
	}
	
	public Transaction getTransaction(String transactionID) throws Exception
	{
		if(!this.transactionRepository.findById(transactionID).isPresent())
			throw new Exception("there is no transaction associated to this Id");
		return this.transactionRepository.findById(transactionID).get();
	}
	
	@Transactional
	public String createTransaction(Transaction transaction)throws Exception
	{

		if(this.userRepository.findById(transaction.getSenderID()).get().getUserID().isEmpty())
			throw new Exception("sender doesn't exist");
		if(this.userRepository.findById(transaction.getReceiverID()).get().getUserID().isEmpty())
			throw new Exception("receiver doesn't exist");
		String transactionID;
		Long amount= transaction.getAmount();
		Long senderBalance= this.userRepository.findById(transaction.getSenderID()).get().getBalance();
		Long receiverBalance= this.userRepository.findById(transaction.getReceiverID()).get().getBalance();
		if(amount>senderBalance)
			throw new Exception("low balance" + senderBalance);
		countID++;
		transactionID="TX";
		for (int i=2 ; i< 6 - countID.toString().length(); i++)
			transactionID=transactionID + "0";
		transactionID=transactionID + countID;
		this.userRepository.findById(transaction.getSenderID()).get().setBalance(senderBalance-amount);
		this.userRepository.findById(transaction.getReceiverID()).get().setBalance(receiverBalance+amount);
		transaction.setTransactionID(transactionID);
		transaction.setAmount(amount);
		if(this.transactionRepository.findById(transaction.getTransactionID()).isPresent())
			throw new Exception("transaction" + transaction.getTransactionID() + "already done");
		this.transactionRepository.save(transaction);
		if(!this.transactionRepository.findById(transaction.getTransactionID()).isPresent())
			throw new Exception("An error occured during the transaction" + transaction.getTransactionID());
		return transaction.getTransactionID() + "done";
	}
}
