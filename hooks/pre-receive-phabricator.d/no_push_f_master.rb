#!/usr/bin/env ruby

# pre-receive hook to block 'push -f' on master
# For Phabricator, save this as:
#   $REPO/hooks/pre-receive-phabricator.d/no_push_f_master.rb
# Remember to chmod +x
# Ref: http://git-scm.com/book/en/Customizing-Git-An-Example-Git-Enforced-Policy

args = STDIN.readline.chomp.split(" ")
$oldrev, $newrev, $refspec = args

# paranoid input check:
SHA_RE = /^[\da-f]{40}$/i
if $oldrev !~ SHA_RE or $newrev !~ SHA_RE then
    puts "invalid input?"
    exit 1
end

# enforces fast-forward only pushes:
def check_fast_forward
  missed_refs = `git rev-list #{$newrev}..#{$oldrev}`
  missed_ref_count = missed_refs.split("\n").size
  if missed_ref_count > 0
    puts "[POLICY] Cannot push a non fast-forward reference"
    puts "[POLICY] missed ref count: #{missed_ref_count}"
    exit 1
  end
end

# don't allow deletes
def check_delete
  if /0{40}/ =~ $newrev then
    puts "[POLICY] delete rejected"
    exit 1
  end
end

# enforcing on master
if $refspec == "refs/heads/master"
    puts "[POLICY:master]"
    check_delete
    check_fast_forward
end
