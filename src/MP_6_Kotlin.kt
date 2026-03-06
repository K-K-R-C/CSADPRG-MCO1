/*
********************
Last names: Camato, Galicia, Mojica, Orense
Language: Kotlin
Paradigm(s): OOP, Functional Programming, and Imperative Programming
********************
*/

//----------------------------------------------------------------------
//Global Variables
//----------------------------------------------------------------------
//All country exchange rates
var pExchange: Double = 1.00
var uExchange: Double = 0.00
var jExchange: Double = 0.00
var bExchange: Double = 0.00
var eExchange: Double = 0.00
var cExchange: Double = 0.00

//----------------------------------------------------------------------
//Classes
//----------------------------------------------------------------------
class Account(var accountName: String = "Anonymous", var balance: Double = 0.0, var currency: String = "PHP")

//----------------------------------------------------------------------
//Functions
//----------------------------------------------------------------------
fun displayDivider()
{
    println("*------------------------------------------------------------------------------*")
}

fun displayMainMenu()
{
    displayDivider()
    println("Select Transaction: ")
    println("[1] Register Account Name")
    println("[2] Deposit Amount")
    println("[3] Withdraw Amount")
    println("[4] Record Exchange Rates")
    println("[5] Currency Exchange")
    println("[6] Show Interest Computation")
    displayDivider()
}

fun displayMainMenuExit()
{
    displayDivider()
    println("EXITING TRANSACTION APP")
    displayDivider()
}

//Helper function
fun getRate(option: Int): Double
{
    var rate: Double = 0.0

    when (option) {
        1 -> rate = pExchange
        2 -> rate = uExchange
        3 -> rate = jExchange
        4 -> rate = bExchange
        5 -> rate = eExchange
        6 -> rate = cExchange
        else -> rate = 1.0
    }

    return rate
}


fun  registerAccountName(account: Account)
{
    var name: String

    //Transaction Title
    println("Register Account Name")
    println()
    //Ask user for Account name
    print("Account Name: ")
    name = readLine()!!

    //Set Account name
    account.accountName = name
}

fun depositAmount(account: Account)
{
    var amount: Double

    //Transaction title
    println("Deposit Amount")
    println()
    println("Account Name: ${account.accountName}")
    println("Current Balance: %.2f".format(account.balance))
    println("Currency: ${account.currency}")
    println()

    //Deposit money into account
    print("Deposit Amount: ")
    amount = readLine()!!.toDouble()

    //Update account balance
    account.balance += amount
    println("Updated Balance: %.2f".format(account.balance))
}

fun withdrawAmount(account: Account)
{
    var amount: Double

    //Transaction title
    println("Deposit Amount")
    println()
    println("Account Name: ${account.accountName}")
    println("Current Balance: %.2f".format(account.balance))
    println("Currency: ${account.currency}")
    println()

    //Withdraw money from account
    print("Withdraw Amount: ")
    amount = readLine()!!.toDouble()

    //Update balance
    account.balance -= amount
    println("Updated balance: %.2f".format(account.balance))
}

fun recordExchangeRate(account: Account)
{
    var choice: Int

    //Transaction title
    println("Record Exchange Rate")
    println()

    //Show currency options
    println("[1] Philippine Peso (PHP)")
    println("[2] United States Dollar (USD)")
    println("[3] Japanese Yen (JPY)")
    println("[4] British Pound Sterling (GBP)")
    println("[5] Euro (EUR)")
    println("[6] Chinese Yuan Renminbi (CNY)")
    println()

    //Ask user for currency choice
    print("Select Foreign Currency: ")
    choice = readLine()!!.toInt()

    //Record exchange rates depending on user's input
    when (choice) {
        1 -> {
            print("Exchange Rate: ")
            pExchange = readLine()!!.toDouble()
        }
        2 -> {
            print("Exchange Rate: ")
            uExchange = readLine()!!.toDouble()
        }
        3 -> {
            print("Exchange Rate: ")
            jExchange = readLine()!!.toDouble()
        }
        4 -> {
            print("Exchange Rate: ")
            bExchange = readLine()!!.toDouble()
        }
        5 -> {
            print("Exchange Rate: ")
            eExchange = readLine()!!.toDouble()
        }
        6 -> {
            print("Exchange Rate: ")
            cExchange = readLine()!!.toDouble()
        }
    }
}

fun currencyExchange(account: Account)
{
    var convertOption: String = "N"
    var sourceChoice: Int
    var sourceAmount: Double
    var exchangeChoice: Int
    var exchangeAmount: Double

    var sourceRate: Double
    var exchangeRate: Double

    //Transaction title
    println("Foreign Currency Exchange")
    println()

    //Keep asking if user wants to convert for other currencies
    do
    {
        if (convertOption == "Y")
            displayDivider()
        //Show source currency options
        println("Source Currency Options: ")
        println("[1] Philippine Peso (PHP)")
        println("[2] United States Dollar (USD)")
        println("[3] Japanese Yen (JPY)")
        println("[4] British Pound Sterling (GBP)")
        println("[5] Euro (EUR)")
        println("[6] Chinese Yuan Renminbi (CNY)")
        println()

        //Ask user for source currency and store for future use
        print("Source Currency: ")
        sourceChoice = readLine()!!.toInt()
        sourceRate = getRate(sourceChoice)
        print("Source Amount: ")
        sourceAmount = readLine()!!.toDouble()
        println()

        //Show exchange currency options
        println("Exchange Currency Options: ")
        println("[1] Philippine Peso (PHP)")
        println("[2] United States Dollar (USD)")
        println("[3] Japanese Yen (JPY)")
        println("[4] British Pound Sterling (GBP)")
        println("[5] Euro (EUR)")
        println("[6] Chinese Yuan Renminbi (CNY)")
        println()

        //Ask user for exchange currency and store for future use
        print("Exchange Currency: ")
        exchangeChoice = readLine()!!.toInt()
        exchangeRate = getRate(exchangeChoice)

        //Calculate for exchange amount
        exchangeAmount = sourceAmount * (sourceRate/exchangeRate)
        println("Exchange amount: %.02f".format(exchangeAmount))
        println()

        //Ask if user wants to convert for other currencies
        print("Convert another currency (Y/N): ")
        convertOption = readLine()!!
        println()
    } while (convertOption == "Y")
}

fun showInterestAmount(account: Account)
{
    val annualInterestRate: Double = 5.0
    var totalDays: Int = 0
    var dailyInterest: Double
    var endOfDayBalance: Double = account.balance


    //Transaction title
    println("Show Interest Amount")
    println()
    println("Account Name: ${account.accountName}")
    println("Current Balance: %.2f".format(account.balance))
    println("Currency: ${account.currency}")
    println("Interest Rate: $annualInterestRate%")
    println()

    //Ask the user for the total days to show daily interest
    print("Total Number of Days: ")
    totalDays = readLine()!!.toInt()
    println()

    //Compute for daily interest
    dailyInterest = endOfDayBalance * ((annualInterestRate/100) / 365)

    //Show the daily interest amount table
    println("Day | Interest | Balance |")

    for (i in 1..totalDays) {
        endOfDayBalance += dailyInterest
        println("%-4d| %-9.02f| %-8.02f|".format(i, dailyInterest, endOfDayBalance))
    }
}

//----------------------------------------------------------------------
//Main
//----------------------------------------------------------------------
fun main() {
    var option : Int
    var back : String
    val account = Account()


    do
    {
        displayMainMenu()

        print("OPTION CHOSEN: ")
        option = readLine()!!.toInt()
        displayDivider()

        when (option)
        {
            1 -> registerAccountName(account)
            2 -> depositAmount(account)
            3 -> withdrawAmount(account)
            4 -> recordExchangeRate(account)
            5 -> currencyExchange(account)
            6 -> showInterestAmount(account)
        }

        do
        {
            println()
            print("Back to the Main Menu (Y/N)?: ")
            back = readLine()!!
        } while(back != "Y" && back != "N")

    } while(back != "N")

    displayMainMenuExit()
}