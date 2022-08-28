package com.example.bank.transaction;

import java.util.Objects;

import javax.persistence.*;

@Entity(name= "transaction")
public class Transaction {
	
	@Column(name= "transactionID",
			nullable= false,
			updatable= false)
	@Id
	private String transactionID;
	@Column(name= "senderID",
			nullable= false)
	private String senderID;
	@Column(name= "recieverID",
			nullable= false)
	private String receiverID;
	@Column(name= "amount",
			nullable= false)
	private Long amount;
	
	public Transaction() {}

	public String getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(String transactionID) {
		this.transactionID = transactionID;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount, receiverID, senderID, transactionID);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		return Objects.equals(amount, other.amount) && Objects.equals(receiverID, other.receiverID)
				&& Objects.equals(senderID, other.senderID) && Objects.equals(transactionID, other.transactionID);
	}

	@Override
	public String toString() {
		return "Transaction [transactionID=" + transactionID + ", senderID=" + senderID + ", receiverID=" + receiverID
				+ ", amount=" + amount + "]";
	}
	
	
}
