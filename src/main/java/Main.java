public class Main {
    public static void main(String[] args) {
        DataRetriever retriever = new DataRetriever();
        //System.out.println(retriever.countAllVotes());
        //System.out.println(retriever.countVotesByType());
        //System.out.println(retriever.countValidVotesByCandidate());
        //System.out.println(retriever.computeVoteSummary());
        System.out.println(retriever.computeTurnoutRate() + "%");
    }

}

