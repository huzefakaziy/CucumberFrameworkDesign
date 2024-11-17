Feature:  Product Search

@SearchProductTest
Scenario Outline: Product search in both Home and Offers page
Given User is on GreenCart landing page
When User search with shortname <Name> and extract actual name of the product
Then User searched for <Name> shortname in offers page
And Validate product name in offers page matches with landing page

Examples:
| Name |
| Tom |
| Beet |
