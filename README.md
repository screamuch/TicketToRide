# TicketToRide
#### by Peter Chudinov (@peterchudinov), Adeeb Rahman (@adman94) and Damir Gafic (@damirgafic)

## Ticket To Ride v0.3

1. **Map covers:**
Vancouver-Calgary-LA-El Paso
2. **Routes:**
No colors, single routes (ignore doubles), total length: 70
3. **Player:**
20 train cars available to play with, no Train Car cards
4. **Destination Tickets:**
All within the map (from original game)
5. **Flexibility:**
Describe any map in `Route.java`/`DestinationTicket.java`
6. **To run this on your computer**
Nothing new here, `git clone`, `javac *` and `java TicketToRideGUI`. Have fun.

##### Old notes to the group:

###### *DONT YOU FUCKING DARE COMMITING INTO MASTER*

###### *DONT EVEN THINK OF TOUCHING MASTER*

###### *MAKE A BRANCH, COMMIT INTO IT AND MAKE A PULL REQUEST*

###### *WHEN MERGING A PULL REQUEST - SQUASH AND FUCKING MERGE*

###### *MAKE A NEW BRANCH FOR EACH NEW FEATURE, NAME ACCORDINGLY!*

Every time you start working on this:
1. `git checkout master`
2. `git pull`
3. `git checkout <your_branch>`
4. `git rebase master`

Usefull git commands:
1. `git diff` - shows what you added since last commit + trailing whitespaces
2. `git stash` - removes unadded changes, helpfull when rebasing ugly shit (can pull them out later)
3. `git reset .` - resets your changes
4. `git branch` - shows current branch
5. `git status` - to see what's up with git

<3 Peter
