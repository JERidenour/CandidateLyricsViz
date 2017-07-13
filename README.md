[Click here for a full size image of the Candidate Cluster graph](http://jonathanridenour.net/projects/candidate_cluster.html).

![Candidate Cluster png](https://github.com/JERidenour/CandidateLyricsViz/blob/master/src/main/resources/CandidateCluster.png)

[Click here for a full size image of the CandidateHub graph](http://www.jonathanridenour.net/projects/candidate_hub.html).

![Candidate Hub png](https://github.com/JERidenour/CandidateLyricsViz/blob/master/src/main/resources/CandidateHub.png)

## What is this?

The blog [FiveThirtyEight](http://fivethirtyeight.com/) did an analysis last year (2016) about how hip-hop artists discuss Trump and the other 2016 presidential candidates in their lyrics. [The article](https://projects.fivethirtyeight.com/clinton-trump-hip-hop-lyrics/) is a very interesting read and they produced a detailed [dataset](https://github.com/fivethirtyeight/data/tree/master/hip-hop-candidate-lyrics).

I wanted to draw a large graph showing which artists would be grouped together based on which candidates they mention. The result is the first graph above, which I call "Candidate Cluster". The idea is simply to create a node for each artist and draw edges between those artists which mention the same candidate, red for Trump, blue for Hillary, and so on. Most of the mentions refer to Trump and Hillary of course, but Bush, Sanders, and Christie are in there too!

The "Candidate Cluster" graph takes awhile to load so I made a smaller graph, "Candidate Hub", which includes the candidates themselves as nodes. Here the artists which mention a candidate have an edge connecting them not to each other, but to the candidate in question. This is basically the same information but with much fewer edges.

## Compile and run

You need graphviz, scala, and sbt installed. Once you have that, put the  [dataset](https://github.com/fivethirtyeight/data/tree/master/hip-hop-candidate-lyrics) in the resources folder and open a terminal at the project root. You can then compile with `sbt compile`, run with `sbt run`.
