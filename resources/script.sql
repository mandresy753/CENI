select count(*) total_votes from vote;

select vote_type, count(*) votes from vote
group by vote_type;

SELECT
    c.name,
    COUNT(CASE WHEN v.vote_type = 'VALID' THEN 1 END) AS valid_votes
FROM candidate c
         JOIN vote v
              ON v.candidate_id = c.id
GROUP BY c.name;

