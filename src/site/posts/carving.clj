(ns site.posts.carving
  (:require [hiccup2.core :as h]))

(defn page []
  (h/html [:p
           [:img {:src "/img/cherry.jpg", :alt "blossoms"}]]
          [:sup "Fuji XT-4 | 35mm ƒ/1.4"]
          [:p "dusting off the old scrolls"]
          [:hr]
          [:p "a seed was planted by a certain professor Clark some years ago, 
           who held his sword of Common Lisp aloft as if it was he that pull'd 
           it from the stone. armed with thin clients and a bucket full of parenthesis, 
           he led a brave charge attempting to  teach the merits of "
           [:a {:href "https://en.wikipedia.org/wiki/Homoiconicity"} "homoiconicity"]
           " and " [:a {:href "https://en.wikipedia.org/wiki/Metaprogramming"} "metaprogramming"]
           " to a class full of what could only be described as children. this, 
           of course, could not have possibly been expected to immediately bear 
           fruit, but perhaps this was indeed his plan all along."]
          [:p "like many nerds, i have written my fair share of code."]
          [:p "and, like many nerds, i find some amount of dark joy in the search of tangibility
           within my intangible tools. though usually, for me, the programming language juice 
           is not worth the squeeze. there will always be an amount of friction in converting 
           ideas to computer programs, but many of the caveats and hurdles present in the pythons, 
           golangs, and rusts et al. leave me reaching for them with a weary, reluctant hand."]
          [:p "through poking at CircleCI configurations at work, i found that they expose a "
           [:code "lein"] " repl that you can jack into and " [:del "mortally wound"] " "
           [:a {:href "https://fieldguide.circleci-labs.com/server/data_retention/"} "safely reconfigure your instance."]
           " thusly, Clojure was fresh on the mind when sitting down to begin tinkering on projects anew. many 
           Rich Hickey lectures later, i was sold on its idioms, and began writing much of my 
           nonsense in Clojure, with a sprinkling of " [:a {:href "https://en.wikipedia.org/wiki/Steel_Bank_Common_Lisp"} "SBCL."]]
          [:p "this nonsense includes a rewrite of my webbed site using a Clojure-based static 
           site generator (ish) of my own design, and input method software drawing from "
           [:a {:href "https://books.google.com/books/about/A_Manual_of_Orthographic_Cursive_Shortha.html?id=kQ5SAAAAYAAJ"} "Orthic shorthand"]
           " and pen-computing paradigms of yore who's proof-of-concept, quite frankly, was 
           significantly easier to implement in python."]
          [:p "learning more functional programming concepts and the math behind them, there's a 
           lot of joy for me working in this manner. many of the ideas are new to me, and many 
           are not, but within the nuance of implementation i've found an alignment that allows 
           me an easier flow of ideas. for the first time in a long time, i have a go-to set of 
           brushes with which to express myself."]
          [:p "i am sure like many educators, Clark put forth those ideas wrapped in seemingly 
           archaic methods knowing that we may not be ready for them in that moment. ideas take 
           time to grow, watered and nourished with experience-wrought perspective. but when we
           are ready, we will reach for them almost instinctively. "]
          [:hr]
          [:p
           [:i "onward"]]))
