SELECT @voteRank := @voteRank + 1 as rank, name, votes FROM votes v, (SELECT @voteRank := 0 ) vr order by votes desc;
