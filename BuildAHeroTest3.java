import java.util.Scanner;
import java.util.Random;

public class BuildAHeroTest3
{
    private static Scanner input = new Scanner(System.in);
    
    private static int INITIAL_HERO_HEALTH = 0;
    private static int INITIAL_HERO_ATTACK = 0;
    private static int INITIAL_HERO_MAGIC = 0;
    
    private static int HERO_HEALTH = 0;
    private static int HERO_ATTACK = 0;
    private static int HERO_MAGIC = 0;
    
    private static int INITIAL_MONSTER_HEALTH = 0;
    private static int INITIAL_MONSTER_ATTACK = 0;
    
    private static int MONSTER_HEALTH = 0;
    private static int MONSTER_ATTACK = 0;
    private static String MONSTER_NAME;
    
    private static int Action = 0;
    
    public static void heroCreation()
    {
        Scanner input = new Scanner(System.in);
         System.out.printf("Time to make a Hero!\n");
         
         for (int statPoints = 20; statPoints > 0;) {
            System.out.printf("Your current stats are:\n");
            System.out.printf("Health: %d\n", INITIAL_HERO_HEALTH);
            System.out.printf("Attack Power: %d\n", INITIAL_HERO_ATTACK);
            System.out.printf("Magic Power: %d\n", INITIAL_HERO_MAGIC);
            System.out.println();
            
            System.out.printf("You have %d stat points\n", statPoints);
            System.out.println("Enter 1 to add a stat point to Health (+10 Health)");
            System.out.println("Enter 2 to add a stat point to Attack Power (+1 Attack Power)");
            System.out.println("Enter 3 to add a stat point to Magic Power (+3 Magic Power");
            
            int statSelection = input.nextInt();
            System.out.println();
            
            if (statSelection == 1) {
                statPoints --;
                INITIAL_HERO_HEALTH += 10;
            }
            else if (statSelection == 2) {
                statPoints --;
                INITIAL_HERO_ATTACK += 1;
            }
            else if (statSelection == 3) {
                statPoints --;
                INITIAL_HERO_MAGIC += 3;
            }
            else {
                System.out.printf("%d is not a valid input\n", statSelection);
                System.out.println();
            }
            
                if (statPoints == 0) {
                    System.out.println("Great! You've finished creating your character.");
                    System.out.println("Your stats are:");
                    System.out.printf("Health: %d\n", INITIAL_HERO_HEALTH);
                    System.out.printf("Attack Power: %d\n", INITIAL_HERO_ATTACK);
                    System.out.printf("Magic Power: %d\n", INITIAL_HERO_MAGIC);
                    System.out.println();
                }
        }
    }
    
    public static void monsterCreation()
    {
        Random randomMonster = new Random();
        int monsterSelection = randomMonster.nextInt(3);
        
        
        if (monsterSelection == 0) {
            MONSTER_NAME = "goblin";
            INITIAL_MONSTER_HEALTH = 75;
            INITIAL_MONSTER_ATTACK = 8;
        }
        else if (monsterSelection == 1) {
            MONSTER_NAME = "orc";
            INITIAL_MONSTER_HEALTH = 100;
            INITIAL_MONSTER_ATTACK = 12;
        }
        else if (monsterSelection == 2) {
            MONSTER_NAME = "troll";
            INITIAL_MONSTER_HEALTH = 150;
            INITIAL_MONSTER_ATTACK = 15;
        }
        System.out.printf("You have encountered a(n) %s\n", MONSTER_NAME);
    }
    
    private static void statTransition()
    {
        HERO_HEALTH = INITIAL_HERO_HEALTH;
        HERO_ATTACK = INITIAL_HERO_ATTACK;
        HERO_MAGIC = INITIAL_HERO_MAGIC;
        
        MONSTER_HEALTH = INITIAL_MONSTER_HEALTH;
        MONSTER_ATTACK = INITIAL_MONSTER_ATTACK;
    }
    
   
    
    public static void combatInfo()
    {
        //Print the Monster’s health
        System.out.println("Monster HP: " + MONSTER_HEALTH);
        //Print the Player’s health
        System.out.println("Your HP: " + HERO_HEALTH);
        //Print the Player’s magic points
        System.out.println("Your MP: " + HERO_MAGIC);
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
            Action = input.nextInt();
            System.out.println();
       
        
            //If player chose option 1, (check with equality operator)
            if (Action == 1) {
                //Calculate damage & update monster health using subtraction
                //Calculation: new monster health is old monster health minus hero attack power
                int totalDamage = (((damage.nextInt(HERO_ATTACK/2)) + 1) + ((damage.nextInt(HERO_ATTACK/2)) + 1) + (HERO_ATTACK/2));
                 MONSTER_HEALTH = MONSTER_HEALTH - totalDamage;
                //print attack text:
            System.out.println("You strike the " + MONSTER_NAME + " with your sword for " + totalDamage + " damage");
            System.out.println();
            }
            
                //Else if player chose option 2, (check with equalit yoperator)
                else if (Action == 2) {
                    //If player has 3 or more magic points
                    if (HERO_MAGIC >= 3) {
                    //Calculate damage & update monster health using division
                    //Calculation: new monster health is old monster health divided by two
                    MONSTER_HEALTH = MONSTER_HEALTH / 2;
                    //Reduce player's mana points by the spell cost using subtraction
                    //Calculation: new magic power is old magic power minus 3
                    HERO_MAGIC = HERO_MAGIC - 3;
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
                else if (Action == 3) {
                    //Increment magic points and update players magic using addition
                    //Calculation: new hero magic is old hero magic plus one
                   HERO_MAGIC = HERO_MAGIC + 1;
                //print charging message:
                System.out.println("You focus and charge your magic power.");
                System.out.println();
                }
        
                //Else if the player chose option 4, (check with equality operator)
                else if (Action == 4) {
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
            if (MONSTER_HEALTH > 0 && Action != 4) {   
            //Have monster attack player and print message  
            int monsterDamage = (((damage.nextInt(MONSTER_ATTACK/2)) + 1) + ((damage.nextInt(MONSTER_ATTACK/2)) + 1) + (MONSTER_ATTACK/2));
            HERO_HEALTH = HERO_HEALTH - monsterDamage;
            System.out.println(MONSTER_NAME + " hits you for " + monsterDamage + " damage");
            System.out.println();
            }
            
                //If monster's health is 0 or below
                if (MONSTER_HEALTH <= 0) {
                //Stop combat loop by setting control variable to false
                Action = 9;
                //Print victory message: “You defeated the <monstername>!”
                System.out.println("You defeated the " + MONSTER_NAME);
                }
                
                //Player health is 0 or below
                if (HERO_HEALTH <= 0) {
                    System.out.println("You died");
                    System.out.println("Try Again? 1) Yes or 2) No");
                    //Stop combat loop
                    Action = 9;
                    //Have user input assign to retry variable
                    int Answer;
                    Answer = input.nextInt();
                    
                    //If user decides to retry
                    if (Answer == 1) {
                        //Continue combat loop
                        Action = 0;
                        //Reset data variables to initial
                        MONSTER_HEALTH = INITIAL_MONSTER_HEALTH;
                        MONSTER_ATTACK = INITIAL_MONSTER_ATTACK;
                        HERO_HEALTH = INITIAL_HERO_HEALTH;
                        HERO_ATTACK = INITIAL_HERO_ATTACK;
                        HERO_MAGIC = INITIAL_HERO_MAGIC;
                    }
                }                    
    }
    
    public static void main(String[] args)
    {
      //Hero creation by user stat assignment    
      heroCreation();
      //Random monster creation with pre determined stats
      monsterCreation();
      //Assigning original variables to variables that will be changed
      statTransition();
      
        //Declare variable that will be used for retry answer
        int Answer;
        
        
        
          while (Action != 9) { 
          //Printing of combat information
          combatInfo();
            Action = 0;
              //While Action is neither 1, 2, 3, and 4 OR while Action is 2 without having 3 or more mana
              while ((Action != 1 && Action != 2 && Action != 3 && Action != 4) || (Action == 2 && HERO_MAGIC < 3)) {
              //Combat loop method
              combatLoop1();
            }
              combatLoop2();    
        }    
    } 
}    