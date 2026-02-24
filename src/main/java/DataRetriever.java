import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DataRetriever {

    public long countAllVotes() {
        String sql = """
                select count(*) total_votes from vote
                """;
        long count = 0;
        try(Connection conn = new DBConnection().getConnection();
            Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                count = rs.getLong("total_votes");
            }
        }catch(SQLException e){
            throw new RuntimeException("une erreur s'est produit "+e);
        }

        return count;
    }
    public List<VoteTypeCount> countVotesByType(){
        List<VoteTypeCount>  voteTypeCounts = new ArrayList<>();
        String sql = """
                select vote_type, count(*) votes from vote
                group by vote_type;
                """;
        try(Connection conn = new DBConnection().getConnection();
        Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                VoteTypeCount  voteTypeCount = new VoteTypeCount();
                voteTypeCount.setCount(rs.getInt("votes"));
                String type = rs.getString("vote_type");
                voteTypeCount.setVoteType( VoteTypeEnum.valueOf(type));
                voteTypeCounts.add(voteTypeCount);
            }
        }catch (SQLException e){
            throw new RuntimeException("une erreur s'est produit "+e);
        }
        return voteTypeCounts;
    }

    public List<CandidateVoteCount> countValidVotesByCandidate(){
        List<CandidateVoteCount> CandidateVoteCounts = new ArrayList<>();
        String sql = """
                SELECT
                    c.name candidate_name,
                    COUNT(CASE WHEN v.vote_type = 'VALID' THEN 1 END) AS valid_vote
                FROM candidate c
                         JOIN vote v
                              ON v.candidate_id = c.id
                GROUP BY candidate_name;
                """;
        try(Connection conn = new DBConnection().getConnection();
        Statement stmt = conn.createStatement()){
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                CandidateVoteCount  CandidateVoteCount = new CandidateVoteCount();
                CandidateVoteCount.setCandidateName(rs.getString("candidate_name"));
                CandidateVoteCount.setValidVoteCount(rs.getInt("valid_vote"));
                CandidateVoteCounts.add(CandidateVoteCount);
            }
        }catch (SQLException e){
            throw new RuntimeException("une erreur s'est produit "+e);
        }
        return CandidateVoteCounts;
    }
}
