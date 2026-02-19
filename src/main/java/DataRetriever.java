import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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
}
