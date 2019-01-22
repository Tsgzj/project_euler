(use 'clojure.string)

(def grid (slurp "./data/p_euler/p18/input.in"))
(def grid2 (slurp "./data/p_euler/p67/p067_triangle.txt"))

(defn ngrid [f]
  (map
   (fn [st]
     (map #(Integer/parseInt %) (split st #" ")))
   (split f #"\n")))

(defn maxPathSum [grid]
  (if (= 1 (count grid))
    (first grid)
    (let [prev-max (maxPathSum (drop-last grid))
          cur (last grid)]
      (map max (cons (first cur) (map + prev-max (drop 1 cur)))
           (concat (map + prev-max (drop-last cur)) (list (last cur)))))))

(apply max (maxPathSum (ngrid grid)))
(apply max (maxPathSum (ngrid grid2)))
