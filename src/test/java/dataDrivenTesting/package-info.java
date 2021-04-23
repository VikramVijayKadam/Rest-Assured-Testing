/**
Data Driven Testing 
-------------------
Sometimes, We need to test the same API with multiple test data, so in that case we can go with data driven testing approch.

Before Starting, we need follow few steps:
1. Prepare the test data in MS-Excel and to read and write we need to use Apache POI
2. Ass Apache POI dependency in pom.xml or download Apache POI & attach jars to your project build path.
3. XL Utility file(java class file) which read data from MS-Excel
4. Write TestNG test with DataProvider Method

 */
/**
 * @author Vikram Vijay Kadam
 *
 */
package dataDrivenTesting;