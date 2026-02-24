select count(*) total_votes from vote;

select vote_type, count(*) votes from vote
group by vote_type;

SELECT
    c.name candidate_name,
    COUNT(CASE WHEN v.vote_type = 'VALID' THEN 1 END) AS valid_vote
FROM candidate c
         JOIN vote v
              ON v.candidate_id = c.id
GROUP BY candidate_name;

select count(case when v.vote_type = 'VALID' then 1 end) valid_count,
       count(case when v.vote_type = 'BLANK' then 1 end) blank_count,
       count(case when v.vote_type = 'NULL' then 1 end) null_count
from vote v;

select count(*) ,
       count(case when v.voter_id is null then 0 end) from voter
join vote v
on v.voter_id  = voter.id;


SELECT
    c.name candidate_name,
    COUNT(CASE WHEN v.vote_type = 'VALID' THEN 1 END) AS valid_vote_count
FROM candidate c
         JOIN vote v
              ON v.candidate_id = c.id
GROUP BY candidate_name
order by valid_vote_count desc
limit 1

