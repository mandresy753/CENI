public class VoteTypeCount {
    private VoteTypeEnum voteType;
    private int count;
    public VoteTypeCount(){}

    public VoteTypeEnum getVoteType() {
        return voteType;
    }

    public void setVoteType(VoteTypeEnum voteType) {
        this.voteType = voteType;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "VoteTypeCount{" +
                "voteType=" + voteType +
                ", count=" + count +
                '}';
    }
}
