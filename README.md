[Click here for a full size image of the CandidateCluster graph](http://jonathanridenour.net/projects/candidate_cluster.html).

![CandidateCluster png](https://github.com/JERidenour/CandidateLyricsViz/blob/master/src/main/resources/CandidateCluster.png)

[Click here for a full size image of the CandidateHub graph](http://www.jonathanridenour.net/projects/candidate_hub.html).

![CandidateCluster png](https://github.com/JERidenour/CandidateLyricsViz/blob/master/src/main/resources/CandidateHub.png)

## What is this?

The blog [FiveThirtyEight](http://fivethirtyeight.com/) did an analysis last year (2016) about how hip-hop artists discuss Trump and the other 2016 presidential candidates in their lyrics. [The article](https://projects.fivethirtyeight.com/clinton-trump-hip-hop-lyrics/) is a very interesting read and they produced a detailed [dataset](https://github.com/fivethirtyeight/data/tree/master/hip-hop-candidate-lyrics).

I wanted to draw a large graph showing which artists would be grouped together based on which candidates they mention. The result is the first graph above, which I call "CandidateCluster". The idea is simply to create a node for each artist and draw edges between those artists which mention the same candidate, red for Trump, blue for Hillary, and so on. Most of the mentions refer to Trump and Hillary of course, but Bush, Sanders, and Christie are in there too!

## Compile and run

You need graphviz, scala, and sbt installed. Once you have that, just open a terminal at the project root and compile with `sbt compile`, run with `sbt run`.
