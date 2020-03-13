# Sum Three

A quick little single-page application for totaling 3 scores (1-9) in a circular buffer.

### Development mode

The app was initialized from the `reagent-frontend` template:
```
lein new reagent-frontend sum-three
```

To start the Figwheel compiler, navigate to the project folder and run the following command in the terminal:

```
lein figwheel
```

Figwheel will automatically push cljs changes to the browser.
Once Figwheel starts up, you should be able to open the `public/index.html` page in the browser.

### REPL

The project is setup to start nREPL on port `7002` once Figwheel starts.
Once you connect to the nREPL, run `(cljs)` to switch to the ClojureScript REPL.

### Building for Production

```
lein clean
lein package
```

### Deploying Production Artifacts

Copy `public/js/app.js`, `public/index.html`, and `public/css/site.css` to a static site.
