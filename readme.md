<center># Programare in Retea
</center></br>
<center>### Laboratorul 1</center></br>


Root@DESKTOP-NMRRI1K MINGW64 ~
$ cd PSproiects
bash: cd: PSproiects: No such file or directory

Root@DESKTOP-NMRRI1K MINGW64 ~
$ cd PRproiects

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -a
fatal: Unable to create 'C:/Users/Root/PRproiects/.git/index.lock': File exists.

Another git process seems to be running in this repository, e.g.
an editor opened by 'git commit'. Please make sure all processes
are terminated then try again. If it still fails, a git process
may have crashed in this repository earlier:
remove the file manually to continue.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -a readme.md
fatal: Paths with -a does not make sense.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -m readme.md
fatal: Unable to create 'C:/Users/Root/PRproiects/.git/index.lock': File exists.

Another git process seems to be running in this repository, e.g.
an editor opened by 'git commit'. Please make sure all processes
are terminated then try again. If it still fails, a git process
may have crashed in this repository earlier:
remove the file manually to continue.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git add readme.md
fatal: Unable to create 'C:/Users/Root/PRproiects/.git/index.lock': File exists.

Another git process seems to be running in this repository, e.g.
an editor opened by 'git commit'. Please make sure all processes
are terminated then try again. If it still fails, a git process
may have crashed in this repository earlier:
remove the file manually to continue.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit --amend
fatal: Unable to create 'C:/Users/Root/PRproiects/.git/index.lock': File exists.

Another git process seems to be running in this repository, e.g.
an editor opened by 'git commit'. Please make sure all processes
are terminated then try again. If it still fails, a git process
may have crashed in this repository earlier:
remove the file manually to continue.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit --amend --no-edit
fatal: Unable to create 'C:/Users/Root/PRproiects/.git/index.lock': File exists.

Another git process seems to be running in this repository, e.g.
an editor opened by 'git commit'. Please make sure all processes
are terminated then try again. If it still fails, a git process
may have crashed in this repository earlier:
remove the file manually to continue.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git add readme.md
warning: LF will be replaced by CRLF in readme.md.
The file will have its original line endings in your working directory

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit --amend
hint: Waiting for your editor to close the file... error: There was a problem with the editor 'vi'.
Please supply the message using either -m or -F option.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit --amend --no-edit
[master 7093504] first commit
 Date: Fri Feb 8 23:07:33 2019 +0200
 1 file changed, 3 insertions(+)
 create mode 100644 readme.md

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -m readme.md
On branch master
Your branch and 'origin/master' have diverged,
and have 1 and 1 different commits each, respectively.
  (use "git pull" to merge the remote branch into yours)

nothing to commit, working tree clean

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull
fatal: refusing to merge unrelated histories

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull -u origin master
error: unknown switch `u'
usage: git pull [<options>] [<repository> [<refspec>...]]

    -v, --verbose         be more verbose
    -q, --quiet           be more quiet
    --progress            force progress reporting
    --recurse-submodules[=<on-demand>]
                          control for recursive fetching of submodules

Options related to merging
    -r, --rebase[=(false|true|merges|preserve|interactive)]
                          incorporate changes by rebasing rather than merging
    -n                    do not show a diffstat at the end of the merge
    --stat                show a diffstat at the end of the merge
    --log[=<n>]           add (at most <n>) entries from shortlog to merge commit message
    --signoff[=...]       add Signed-off-by:
    --squash              create a single commit instead of doing a merge
    --commit              perform a commit if the merge succeeds (default)
    --edit                edit message before committing
    --ff                  allow fast-forward
    --ff-only             abort if fast-forward is not possible
    --verify-signatures   verify that the named commit has a valid GPG signature
    --autostash           automatically stash/stash pop before and after rebase
    -s, --strategy <strategy>
                          merge strategy to use
    -X, --strategy-option <option=value>
                          option for selected merge strategy
    -S, --gpg-sign[=<key-id>]
                          GPG sign commit
    --allow-unrelated-histories
                          allow merging unrelated histories

Options related to fetching
    --all                 fetch from all remotes
    -a, --append          append to .git/FETCH_HEAD instead of overwriting
    --upload-pack <path>  path to upload pack on remote end
    -f, --force           force overwrite of local branch
    -t, --tags            fetch all tags and associated objects
    -p, --prune           prune remote-tracking branches no longer on remote
    -j, --jobs[=<n>]      number of submodules pulled in parallel
    --dry-run             dry run
    -k, --keep            keep downloaded pack
    --depth <depth>       deepen history of shallow clone
    --unshallow           convert to a complete repository
    --update-shallow      accept refs that update .git/shallow
    --refmap <refmap>     specify fetch refmap
    -4, --ipv4            use IPv4 addresses only
    -6, --ipv6            use IPv6 addresses only


Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git push -u origin master
To https://github.com/anagogu/PR.git
 ! [rejected]        master -> master (non-fast-forward)
error: failed to push some refs to 'https://github.com/anagogu/PR.git'
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. Integrate the remote changes (e.g.
hint: 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull --commit
fatal: refusing to merge unrelated histories

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git fetch

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull
fatal: refusing to merge unrelated histories

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -m "second commit"
On branch master
Your branch and 'origin/master' have diverged,
and have 1 and 1 different commits each, respectively.
  (use "git pull" to merge the remote branch into yours)

nothing to commit, working tree clean

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git push -u origin master
To https://github.com/anagogu/PR.git
 ! [rejected]        master -> master (non-fast-forward)
error: failed to push some refs to 'https://github.com/anagogu/PR.git'
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. Integrate the remote changes (e.g.
hint: 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ ls readme.md
readme.md

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git add readme.md

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -m "second commit"
On branch master
Your branch and 'origin/master' have diverged,
and have 1 and 1 different commits each, respectively.
  (use "git pull" to merge the remote branch into yours)

nothing to commit, working tree clean

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull
fatal: refusing to merge unrelated histories

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull origin master
From https://github.com/anagogu/PR
 * branch            master     -> FETCH_HEAD
fatal: refusing to merge unrelated histories

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git push -u origin master
To https://github.com/anagogu/PR.git
 ! [rejected]        master -> master (non-fast-forward)
error: failed to push some refs to 'https://github.com/anagogu/PR.git'
hint: Updates were rejected because the tip of your current branch is behind
hint: its remote counterpart. Integrate the remote changes (e.g.
hint: 'git pull ...') before pushing again.
hint: See the 'Note about fast-forwards' in 'git push --help' for details.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git pull --rebase
First, rewinding head to replay your work on top of it...
Applying: first commit
Using index info to reconstruct a base tree...
Falling back to patching base and 3-way merge...
Auto-merging readme.md
CONFLICT (add/add): Merge conflict in readme.md
error: Failed to merge in the changes.
hint: Use 'git am --show-current-patch' to see the failed patch
Patch failed at 0001 first commit
Resolve all conflicts manually, mark them as resolved with
"git add/rm <conflicted_files>", then run "git rebase --continue".
You can instead skip this commit: run "git rebase --skip".
To abort and get back to the state before "git rebase", run "git rebase --abort".

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master|REBASE 1/1)
$ git add/rm readme.md
git: 'add/rm' is not a git command. See 'git --help'.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master|REBASE 1/1)
$ git rm readme.md
readme.md: needs merge
rm 'readme.md'

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master|REBASE 1/1)
$ git rm 'readme.md'
fatal: pathspec 'readme.md' did not match any files

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master|REBASE 1/1)
$ git rebase --continue
Applying: first commit

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -m "first commit"
On branch master
Your branch is ahead of 'origin/master' by 1 commit.
  (use "git push" to publish your local commits)

nothing to commit, working tree clean

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git push -u origin master
Enumerating objects: 3, done.
Counting objects: 100% (3/3), done.
Writing objects: 100% (2/2), 200 bytes | 100.00 KiB/s, done.
Total 2 (delta 0), reused 0 (delta 0)
To https://github.com/anagogu/PR.git
   01eef7a..7f3e4a4  master -> master
Branch 'master' set up to track remote branch 'master' from 'origin'.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git add readme.md
fatal: pathspec 'readme.md' did not match any files

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ ls readme.md
ls: cannot access 'readme.md': No such file or directory

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ ls readme.md
readme.md

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git add readme.md
warning: LF will be replaced by CRLF in readme.md.
The file will have its original line endings in your working directory

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git commit -m "second commit"
[master 2cfd8b5] second commit
 1 file changed, 3 insertions(+)
 create mode 100644 readme.md

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$ git push -u origin master
Enumerating objects: 4, done.
Counting objects: 100% (4/4), done.
Delta compression using up to 2 threads
Compressing objects: 100% (2/2), done.
Writing objects: 100% (3/3), 300 bytes | 100.00 KiB/s, done.
Total 3 (delta 0), reused 0 (delta 0)
To https://github.com/anagogu/PR.git
   7f3e4a4..2cfd8b5  master -> master
Branch 'master' set up to track remote branch 'master' from 'origin'.

Root@DESKTOP-NMRRI1K MINGW64 ~/PRproiects (master)
$
