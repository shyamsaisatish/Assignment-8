package lab8;
import java.util.*;
import java.util.stream.Collectors;
public class Qtester {
		public static void main(String[] args) {
			List<Transaction> transactionList = getAllTransactions();
			System.out.println("---------------------------------1. Find all transactions in the year 2011 and sort them by value (small to high)---------------------------------");
			List<Transaction> listAllTransactionsInTheYear2011 = transactionList.stream()
					.filter(year -> year.getYear() == 2011)
					.sorted((o1, o2) -> Integer.compare(o1.getValue(), o2.getValue())).collect(Collectors.toList());
			listAllTransactionsInTheYear2011.forEach(list -> System.out.println(list));
			System.out.println("------------------------------------2. What are all the unique cities where the traders work?------------------------------------");
			List<Trader> getAllTraders = transactionList.stream()
														.map(transaction->transaction.getTrader())
														.distinct()
														.collect(Collectors.toList());
			
			List<String> getAllTradersCity = getAllTraders.stream()
														.map(trader -> trader.getCity())
														.distinct()
														.collect(Collectors.toList());
			System.out.println(getAllTradersCity);
			System.out.println("--------------------------3. Find all traders from delhi and sort them by name------------------------------");
			List<Trader> getAllTradersFromDelhi = getAllTraders.stream()
															.filter(city->city.getCity().equals("delhi"))
															.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
															.collect(Collectors.toList());
		
			getAllTradersFromDelhi.forEach(trader->System.out.println(trader));													
			
			
			System.out.println("--------------------------------4. Return a string of all traders names sorted alphabetically.-----------------------------------");
			List<Trader> getAllTradersSortedAlphabetically = getAllTraders.stream()
																	.sorted((o1, o2) -> o1.getName().compareTo(o2.getName()))
																.collect(Collectors.toList());
			
			System.out.println(getAllTradersSortedAlphabetically);
			
			
			System.out.println("--------------------------------5. Are any traders based in Jaipur?--------------------------------");
			
			boolean anyTraderBasedOnJaipur = getAllTraders.stream()
														.anyMatch(trader->trader.getCity().equals("jaipur"));
			if(anyTraderBasedOnJaipur) {
				System.out.println("Yes! some traders are from jaipur");
			} else {
				System.out.println("No traiders are from jaipur");
			}
			
			System.out.println("--------------------------------------6. Print all transactions values from the traders living in delhi----------------------------");
			
			List<Integer> printValueLivingInDelhi = transactionList.stream()
							.filter(city->city.getTrader().getCity().equals("delhi"))
							.map(value -> value.getValue())
							.collect(Collectors.toList());
			
			printValueLivingInDelhi.forEach(getValue->System.out.println(getValue));
		
			
			System.out.println("--------------------------7. Whats the highest value of all the transactions?-----------------------------------------------");
			
			OptionalInt maxValueFromTransactions = transactionList.stream()
																.mapToInt(value->value.getValue())
																.max();

			System.out.println(maxValueFromTransactions);
				
			
			System.out.println("---------------------------8. Find the transaction with the smallest value----------------------------------");
			
			List<Transaction> transactionWithSmallestValue = transactionList.stream()
													.limit(1)
													.sorted((Transaction o1, Transaction o2) ->  Integer.compare(o1.getValue(), o2.getValue()))
													.collect(Collectors.toList());
			
			System.out.println(transactionWithSmallestValue);

		}

		private static List<Transaction> getAllTransactions() {

			Trader ram = new Trader("ram", "delhi");
			Trader kapil = new Trader("kapil", "noida");
			Trader raj = new Trader("raj", "banglore");
			Trader ekta = new Trader("ekta", "banglore");

			List<Transaction> transactions = Arrays.asList(new Transaction(ram, 2011, 300),
					new Transaction(ram, 2012, 1000), new Transaction(kapil, 2011, 400), new Transaction(raj, 2012, 710),
					new Transaction(ekta, 2012, 700), new Transaction(ekta, 2012, 950));

			return transactions;
		}

	}

