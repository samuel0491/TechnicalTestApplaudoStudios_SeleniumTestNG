In this challenge, Applaudos Studios requested me:

For following website: http://automationpractice.com/index.php build a solution to test below conditions:

1. Add item to shopping cart

2. Remove item inside shopping cart

3. Search item (include at least one positive and negative condition)

4. Validate store information (scroll down to footer and check for Store Information)

What did I do?

I created a Maven project and added the dependencies that I needed (Selenium and testng) as below:

![dependecies](https://user-images.githubusercontent.com/13719381/134828556-42cc0bb4-aed4-436b-8f5b-c95852312b03.JPG)

Then, I created the Page Object classes according what element and actions I needed. The model that I implemented was:

![page object model](https://user-images.githubusercontent.com/13719381/134829416-36fb21c1-ed2b-4ca0-9874-b52b6fa02eec.jpg)

I added my test cases into testng.xml file and runned the suite. you should get the following results:

![run suite](https://user-images.githubusercontent.com/13719381/134829567-3c052504-ff01-4f12-bba6-790578defbf1.JPG)

**For this project, I used IntelliJ IDE, so when you clone this project and open it using IntelliJ, every dependencies should be downloaded automatically.**
