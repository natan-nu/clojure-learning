# clojure-learning

My personal workspace for the Nubank Clojure ramp-up — driven by the [`clojure-learning-buddy`](https://nubank.atlassian.net/wiki/spaces/TL/) skill in Claude Code.

## What's here

- `progress.json` — session state (current module, modules completed, challenge attempts/reviews, profile). Don't edit by hand; the buddy maintains it.
- `challenges/<NNN>.clj` — one file per challenge. Pre-loaded at bootstrap with a stub function + the official `-test` reshaped as `(tst)`. Implement the function body; reload the file to run the tests. When `(tst)` returns `"SUCCESS"`, the spec is satisfied.
- `notes/` — free-form notes and scratch from theory modules.

## Sibling repos

The buddy expects these to live next to this repo under `~/dev/nu/`:

- `~/dev/nu/tech-learning-clojure/` — the 9-module curriculum (read-only).
- `~/dev/nu/tlt-clojure-90-challenges-90-days/` — the 90 challenges (read-only).

If they're missing, run `nu projects clone tech-learning-clojure` and `nu projects clone tlt-clojure-90-challenges-90-days`.

## Daily flow

1. Open this repo in IntelliJ. Start the nREPL run config.
2. Run `clojure-learning-buddy` (or type `/clojure-learning-buddy`) in Claude Code.
3. The buddy picks up where you left off, asks language, lists what's next.
4. Theory or challenge — the user does the typing. The buddy asks the questions.
5. After a challenge: structured review against the official solution + Clojure/Nubank idioms.
6. Commit + (optionally) push.

## Getting unstuck

- IntelliJ + Clojure plugins setup: <https://nubank.atlassian.net/wiki/spaces/TL/pages/263981957212/IntelliJ+REPL+Setup>
- 90 challenges overview: <https://nubank.atlassian.net/wiki/spaces/TL/pages/264412533507>
- `#technical-learning-help` on Slack.
