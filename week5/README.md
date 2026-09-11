# Week 5 - Fantasy Sports Coding Problems

This folder contains solutions to 5 coding problems ranging from Easy to Advanced tier, covering arrays, strings, 2D arrays, method overloading, and encapsulation.

## Problems

### Problem 1: Fantasy Team Score Multiplier (Easy)
**File:** `Problem1_FantasyTeamScoreMultiplier.java`

Applies captain (2×) and vice-captain (1.5×) multipliers directly to a player scores array.

**Key Concept:** Arrays passed by reference - modifies original array in place.

```java
static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex)
```

---

### Problem 2: Duplicate Player Pick Checker (Easy)
**File:** `Problem2_DuplicatePlayerPickChecker.java`

Checks a lineup for duplicate player names using nested loops.

**Key Concept:** Pairwise comparison with early exit.

```java
static String findDuplicatePick(String[] playerNames)
```

---

### Problem 3: Top Performer Tracker (Intermediate)
**File:** `Problem3_TopPerformerTracker.java`

Finds min, max, and spread in a single pass without sorting.

**Key Concept:** Single-pass min/max tracking.

```java
static String findMinMaxSpread(int[] scores)
```

---

### Problem 4: Match Day Grid Analyzer (Intermediate)
**File:** `Problem4_MatchDayGridAnalyzer.java`

Classifies matches as "Power Surge" or "Normal" using a helper method for row averages.

**Key Concept:** 2D arrays, helper method reuse, variable-length rows.

```java
static double rowAverage(int[] row)
static String classifyMatches(int[][] runsPerOver, int threshold)
```

---

### Problem 5: Fantasy League Auto-Draft Ranking Engine (Advanced)
**File:** `Problem5_FantasyLeagueAutoDraft.java`

Implements draft eligibility rules with method overloading, Player class with Comparable for sorting by fantasy points.

**Key Concept:** Method overloading, encapsulation, Comparable interface, Arrays.sort().

```java
class Player implements Comparable<Player>
static boolean isDraftable(int matchesPlayed)
static boolean isDraftable(int matchesPlayed, boolean injured)
static String draftAndRank(Player[] players)
```

---

## How to Run

```bash
# Compile all
javac *.java

# Run each problem
java Problem1_FantasyTeamScoreMultiplier
java Problem2_DuplicatePlayerPickChecker
java Problem3_TopPerformerTracker
java Problem4_MatchDayGridAnalyzer
java Problem5_FantasyLeagueAutoDraft
```