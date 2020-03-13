(ns sum-three.core
    (:require
      [reagent.core :as r]
      [reagent.dom :as d]))

;; -------------------------
;; state

(defonce scores (r/atom [0 0 0]))

(defn handle-num-click! [n]
  (swap! scores (comp vec (partial take-last 3) conj) n))

;; -------------------------
;; components

(defn button [n]
  ^{:key n} [:button
             {:on-click #(handle-num-click! n)}
             n])

(defn numpad []
  [:div.pad
   (map-indexed
     (fn [i row]
       ^{:key (str "row-" i)} [:div.row
                               (map (comp button inc)
                                 (range (* row 3) (+ 3 (* row 3))))])
     (range 3))])

;; -------------------------
;; Views

(defn home-page []
  [:div
   [:div.score-line
    (map-indexed
      #(-> ^{:key (str "score-" %1)} [:span.score %2])
      @scores)
    "=" 
    [:span.total (apply + @scores)]]
   (numpad)])

;; -------------------------
;; Initialize app

(defn mount-root []
  (d/render [home-page] (.getElementById js/document "app")))

(defn init! []
  (mount-root))
