(ns test.core)
(use 'clojure.java.io)


;Here we hold true answeres for questions
(def question_answere
  {1 "a" 2 "b" 3 "c" 4 "b" 5 "b" 6 "a" 7 "c" 8 "a" 9 "c" 10 "b" 
   11 "c" 12 "b" 13 "c" 14 "b" 15 "c" 16 "b" 17 "a" 18 "c" 19 "b" 20 "b"
   21 "a" 22 "c" 23 "c" 24 "a" 25 "c" 26 "a" 27 "b" 28 "b" 29 "c" 30 "a"
   31 "b" 32 "c" 33 "a" 34 "b" 35 "b"})


(def path 
    (System/getProperty "user.dir"))
 


(defn read-question
  "This function reads question and three offered answers from our file." 
  [i start] 
  (if (< i 4) 
    (do (with-open [rdr (reader (str path "//src//test//questions.txt"))]
          (println (nth (line-seq rdr) start))
          (read-question (inc i) (+ start 1))))    
    ))



(def s
     0)        

(defn check-answere
  [que-ans iteration s]
  "This function checks the user's answere and generates the score."
   (if (< iteration 10)
     (do (def q
           (rand-int 35))
       
       (read-question 0 (* q 4))    
       (doseq [line (read-line)] 
         (def o
           line))     ;In var o is user's answere 
       
	       (if (= (str "" o) (get que-ans (+ q 1)))
	          (do 
	            (println (str "\nCorrect!" "\n\n"))
	           (check-answere que-ans (inc iteration) (inc s)))
	          (do (println (str "\nIncorrect!" "\n\n"))
	           (check-answere que-ans (inc iteration) s))
	          ))
     ;
     (def score
       s)
   ))


(defn start
  "Starting function."
  [first-last-name]
  (println (str "\n\nHello " first-last-name "! Try this short quiz and check your knowledge about Clojure!"))
  (print "Let's start! \n\n")
  (check-answere question_answere 0 s)
  
  (if (< score 5)
    (print (str "\n\tLearn more! Be tenacious! Google it! " "\n\t~~Total score: " score "/10~~\n\n"))
    (print (str "\n\tYou are good! Nice job! " "\n\t~~Total score: " score "/10~~\n\n")))
 )

