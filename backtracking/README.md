# Back Tracking

## Step

Consists of 3 steps:
    
- Choose: Choose the potential candidate. If already reach target then add to result.
- Constraint: Define a constraint that must be satisfied by the chosen candidate.
- Remove: Do the opposite operation of choose.

## Template 

```java
public class Solution {
    private void dfs(int currentPosition, List<Integer> chosenCandidates) {
        if (foundSolution(candidate)) {
            res.add(new ArrayList<>(chosenCandidates));
            return;
        }
        for (int nextCandidate : getNextCandidates(currentPosition)) {
            if (!isValid(nextCandidate)) {
                continue;
            }
            chosenCandidates.add(nextCandidate);
            dfs(getPosition(nextCandidate), chosenCandidates);
            chosenCandidates.remove(chosenCandidates.size() - 1);
        }
    }
}
```

## Time complexity 

        O((k^n)*n)

## Space complexity

        O(N)