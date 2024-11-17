Feature: Search for Products and Place order

@PlaceOrderTest
Scenario Outline:  Product Search and Order Placemnent
Given User is on GreenCart landing page
When User search with shortname <Name> and extract actual name of the product
And Added "3" items of the selected product to Cart
Then User proceeds to Checkout and validate the <Name> items in Checkout page
And Verify user has ability to enter promocode and place the order

Examples:
| Name |
| Tom  |
| Beet |

