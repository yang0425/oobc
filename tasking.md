Scenario 1: Can park a car in one parking lot with one available parking space
Given: A parking lot with 1 parking space
When: parking a car (JA12345)
Then: Get a ticket(JA12345)

Scenario 2: Can pick up a car after parking it
Given: There’s a car with plate number JA12345 parking in parking lot
When: Pick up with the ticket with number JA12345
Then: The car picked up is the same car parked

Scenario 3: Can’t park a car into a full parking lot
Given: There’s a parking lot with 0 available parking space out of 10 parking space in total
When: Parking a car (JA12345)
Then: Failed to park, there’s an exception threw out

Scenario 4: Can’t pick up a car which is not parked in the parking lot
Given: One car JA12345 is not parked in one parking lot
When: Pick up this car JA12345 from this parking lot
Then: Failed to pick up, there’s an exception threw out

Scenario 5: Cant’ pick up a car which has been picked up from the parking lot
Given: One car JA12345 is parked in one parking lot, and picked it up
When: pick up this car JA12345 again from this parking lot
Then: Failed to pick up, there’s an exception threw out