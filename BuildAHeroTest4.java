import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class BuildAHeroTest4
{
    public static ArrayList<Integer> statWeapon = new ArrayList<>();
    public static ArrayList<Integer> statArmor = new ArrayList<>();
    private static Scanner input = new Scanner(System.in);
    
    private static int initialHeroHealth = 0;
    private static int initalHeroAttack = 0;
    private static int initialHeroMagic = 0;
    private static int initialHeroArmor = 0;
    
    private static int heroHealth = 0;
    private static int heroAttack = 0;
    private static int heroMagic = 0;
    private static int heroArmor = 0;
    private static int weaponAttack = 0;
    private static int experience = 0;
    private static int heroLevel = 1;
    
    private static int initialMonsterHealth = 0;
    private static int initialMonsterAttack = 0;
    
    private static int monsterHealth = 0;
    private static int monsterAttack = 0;
    private static String monsterName;
    
    public static int bronzeSword = 1;
    public static int ironSword = 3; 
    public static int steelSword = 5;
    
    public static String bSword = "Bronze Sword";
    public static String iSword = "Iron Sword";
    public static String sSword = "Steel Sword";
    
    public static int hideArmor = 1;
    public static int chainArmor = 3;
    public static int ironArmor = 5;
    
    public static String hArmor = "Hide Armor";
    public static String cArmor = "Chain Mail";
    public static String iArmor = "Iron Mail";
    
    private static int action = 0;
    
    public static void heroCreation()
    {
        Scanner input = new Scanner(System.in);
         System.out.printf("Time to make a Hero!\n");
         
         for (int statPoints = 20; statPoints > 0;) {
            System.out.printf("Your current stats are:\n");
            System.out.printf("Health: %d\n", initialHeroHealth);
            System.out.printf("Attack Power: %d\n", initalHeroAttack);
            System.out.printf("Magic Power: %d\n", initialHeroMagic);
            System.out.println();
            
            System.out.printf("You have %d stat points\n", statPoints);
            System.out.println("Enter 1 to add a stat point to Health (+10 Health)");
            System.out.println("Enter 2 to add a stat point to Attack Power (+1 Attack Power)");
            System.out.println("Enter 3 to add a stat point to Magic Power (+3 Magic Power");
            
            int statSelection = input.nextInt();
            System.out.println();
            
            if (statSelection == 1) {
                statPoints --;
                initialHeroHealth += 10;
            }
            else if (statSelection == 2) {
                statPoints --;
                initalHeroAttack += 1;
            }
            else if (statSelection == 3) {
                statPoints --;
                initialHeroMagic += 3;
            }
            else {
                System.out.printf("%d is not a valid input\n", statSelection);
                System.out.println();
            }
            
                if (statPoints == 0) {
                    System.out.println("Great! You've finished creating your character.");
                    System.out.println("Your stats are:");
                    System.out.printf("Health: %d\n", initialHeroHealth);
                    System.out.printf("Attack Power: %d\n", initalHeroAttack);
                    System.out.printf("Magic Power: %d\n", initialHeroMagic);
                    System.out.println();
                }
        }
    }
    
    public static void monsterCreation()
    {
        Random randomMonster = new Random();
        int monsterSelection = randomMonster.nextInt(3);
        
        
        if (monsterSelection == 0) {
            monsterName = "goblin";
            initialMonsterHealth = 75;
            initialMonsterAttack = 8;
        }
        else if (monsterSelection == 1) {
            monsterName = "orc";
            initialMonsterHealth = 100;
            initialMonsterAttack = 12;
        }
        else if (monsterSelection == 2) {
            monsterName = "troll";
            initialMonsterHealth = 150;
            initialMonsterAttack = 15;
        }
        System.out.printf("You have encountered a(n) %s\n", monsterName);
    }
    
    private static void statTransition()
    {
        heroHealth = initialHeroHealth;
        heroAttack = initalHeroAttack;
        heroMagic = initialHeroMagic;
        
        monsterHealth = initialMonsterHealth;
        monsterAttack = initialMonsterAttack;
    }
    
   
    
    public static void combatInfo()
    {
        //Print the Monster’s health
        System.out.println("Monster HP: " + monsterHealth);
        //Print the Player’s health
        System.out.println("Your HP: " + heroHealth);
        //Print the Player’s magic points
        System.out.println("Your MP: " + heroMagic);
        System.out.println();
        
        /*Combat menu prompt*/
        //Print option 1: Sword Attack
        System.out.println("1) Sword Attack");
        //Print option 2: Cast Spell
        System.out.println("2) Cast Spell");
        //Print option 3: Charge Mana
        System.out.println("3) Charge Mana");
        //Print option 4: Run Away
        System.out.println("4) Run Away");
        //Prompt player for action
        System.out.println("Action?");
        
        
    }
    
    public static void combatLoop1()
    {
        Random damage = new Random();
        
        //Variable for user input (as number) and acquire value from Scanner object
            action = input.nextInt();
            System.out.println();
       
        
            //If player chose option 1, (check with equality operator)
            if (action == 1) {
                //Calculate damage & update monster health using subtraction
                //Calculation: new monster health is old monster health minus hero attack power
                int totalDamage = (((damage.nextInt((heroAttack+weaponAttack)/2)) + 1) + ((damage.nextInt((heroAttack+weaponAttack)/2)) + 1) + ((heroAttack+weaponAttack)/2));
                 monsterHealth = monsterHealth - totalDamage;
                //print attack text:heroAttack
            System.out.println("You strike the " + monsterName + " with your sword for " + totalDamage + " damage");
            System.out.println();
            }
            
                //Else if player chose option 2, (check with equalit yoperator)
                else if (action == 2) {
                    //If player has 3 or more magic points
                    if (heroMagic >= 3) {
                    //Calculate damage & update monster health using division
                    //Calculation: new monster health is old monster health divided by two
                    monsterHealth = monsterHealth / 2;
                    //Reduce player's mana points by the spell cost using subtraction
                    //Calculation: new magic power is old magic power minus 3
                    heroMagic = heroMagic - 3;
                    //print spell message:
                    System.out.println("You cast the weaken spell on the monster.");
                    System.out.println();
                    }
                    else {
                    System.out.println("You don't have enough mana");
                    System.out.println();
                    }
                
                }
            
                //Else if the player chose option 3, (check with equality operator)
                else if (action == 3) {
                    //Increment magic points and update players magic using addition
                    //Calculation: new hero magic is old hero magic plus one
                   heroMagic = heroMagic + 1;
                //print charging message:
                System.out.println("You focus and charge your magic power.");
                System.out.println();
                }
        
                //Else if the player chose option 4, (check with equality operator)
                else if (action == 4) {
                //print retreat message:
                System.out.println("You run away!");
                System.out.println();
                }
        
                //Else the player chose incorrectly
                else {
                //print an error message:
                System.out.printf("%d is not a valid command.\n");
                System.out.println();
                }
    }
    
    public static void combatLoop2()
    {
        Random damage = new Random();
        
             //If monsters health is above 0 and user did not choose action 4 
            if (monsterHealth > 0 && action != 4) {   
            //Have monster attack player and print message  
            int monsterDamage = (((damage.nextInt(monsterAttack/2)) + 1) + ((damage.nextInt(monsterAttack/2)) + 1) + (monsterAttack/2));
            heroHealth = heroHealth - (monsterDamage-heroArmor);
            System.out.println(monsterName + " hits you for " + monsterDamage + " damage");
            System.out.println();
            }
            
                //If monster's health is 0 or below
                if (monsterHealth <= 0) { 
                //Stop combat loop by setting control variable to false
                action = 9;
                //Print victory message: “You defeated the <monstername>!”
                System.out.println("You defeated the " + monsterName);
                Random itemDropRate = new Random();
                int itemDropChance;    
                    
                    if (monsterName == "goblin") {
                        experience += 1;
                        itemDropChance = itemDropRate.nextInt(4);
                        if (itemDropChance == 0 && heroArmor == 0) {
                            System.out.printf("%s has dropped %s\n",monsterName, hArmor);
                            statArmor.add(hideArmor);    
                            System.out.printf("You have equiped %s\n", hArmor);
                        }
                        else if (itemDropChance == 2 && weaponAttack == 0) {
                            System.out.printf("%s has dropped %s\n",monsterName, bSword);
                            statWeapon.add(bronzeSword);    
                            System.out.printf("You have equiped %s\n", bSword);
                        }
                    }
                    else if (monsterName == "orc") {
                        experience += 3;
                        itemDropChance = itemDropRate.nextInt(6);
                        if (itemDropChance == 0 && heroArmor <= 1) {
                            System.out.printf("%s has dropped %s\n",monsterName, cArmor);
                            heroArmor = 0;
                            statArmor.clear();
                            statArmor.add(chainArmor);    
                            System.out.printf("You have equiped %s\n", cArmor);
                        }
                        else if (itemDropChance == 2 && weaponAttack <= 1) {
                            System.out.printf("%s has dropped %s\n",monsterName, iSword);
                            weaponAttack = 0;
                            statWeapon.clear();
                            statWeapon.add(ironSword);    
                            System.out.printf("You have equiped %s\n", iSword);
                        }    
                    }
                    else if (monsterName == "troll") {
                        experience += 5;
                        itemDropChance = itemDropRate.nextInt(8);
                        if (itemDropChance == 0 && heroArmor <= 3) {
                            System.out.printf("%s has dropped %s\n",monsterName, iArmor);
                            heroArmor = 0;
                            statArmor.clear();
                            statArmor.add(ironArmor);    
                            System.out.printf("You have equiped %s\n", iArmor);
                        }
                        else if (itemDropChance == 2 && weaponAttack <= 3) {
                            System.out.printf("%s has dropped %s\n",monsterName, sSword);
                            weaponAttack = 0;
                            statWeapon.clear();
                            statWeapon.add(steelSword);    
                            System.out.printf("You have equiped %s\n", sSword);
                        }    
                    }
                    
                    if (experience >= 5 && heroLevel == 1) {
                        heroLevel = 2;
                        System.out.printf("You have reached level %d\n", heroLevel);
                        experience = 0;
                        initialHeroHealth += 5;
                        initalHeroAttack += 1;
                        initialHeroMagic += 2;
                    }
                    else if (experience >= 10 && heroLevel == 2) {
                        heroLevel = 3;
                        System.out.printf("You have reached level %d\n", heroLevel);
                        experience = 0;
                        initialHeroHealth += 5;
                        initalHeroAttack += 1;
                        initialHeroMagic += 2;
                    }
                    else if (experience >= 15 && heroLevel == 3) {
                        heroLevel = 4;
                        System.out.printf("You have reached level %d\n", heroLevel);
                        experience = 0;
                        initialHeroHealth += 5;
                        initalHeroAttack += 1;
                        initialHeroMagic += 2;
                }
                
                if (statArmor.isEmpty() == false) {
                    heroArmor = statArmor.get(0);
                }
                if (statWeapon.isEmpty() == false) {
                    weaponAttack = statWeapon.get(0);
                }
                int choice = 0; 
                do {
                        System.out.println("Continue to next foe? 1) Yes or 2) No");
                        choice = input.nextInt();
                        if (choice == 2) {
                            action = 9;
                        }
                        else if (choice == 1) {
                        }
                        else {
                            System.out.printf("%s is an invalid input\n", choice);
                        }
                    } while (choice == 0);
        }    
                
                //Player health is 0 or below
                if (heroHealth <= 0) {
                    System.out.println("You died");
                    System.out.println("Try Again? 1) Yes or 2) No");
                    //Stop combat loop
                    action = 9;
                    //Have user input assign to retry variable
                    int answer;
                    answer = input.nextInt();
                    
                    //If user decides to retry
                    if (answer == 1) {
                        //Continue combat loop
                        action = 0;
                        //Reset data variables to initial
                        monsterHealth = initialMonsterHealth;
                        monsterAttack = initialMonsterAttack;
                        heroHealth = initialHeroHealth;
                        heroAttack = initalHeroAttack;
                        heroMagic = initialHeroMagic;
                    }
                }
    }
    
    public static void main(String[] args)
    {
          //Hero creation by user stat assignment    
          heroCreation();
          
          while (action != 9) {
          //Random monster creation with pre determined stats
          monsterCreation();
          //Assigning original variables to variables that will be changed
          statTransition();
          
            //Declare variable that will be used for retry answer
            int answer;
            
            
            
              while (action != 9) { 
              //Printing of combat information
              combatInfo();
                action = 0;
                  //While Action is neither 1, 2, 3, and 4 OR while Action is 2 without having 3 or more mana
                  while ((action != 1 && action != 2 && action != 3 && action != 4) || (action == 2 && heroMagic < 3)) {
                  //Combat loop method
                  combatLoop1();
                }
                  combatLoop2();    
            }  
        }    
    } 
}    