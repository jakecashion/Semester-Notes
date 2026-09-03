#!/usr/bin/env python3
"""Verify every .java file under this class folder has a filled-in author header.

Required per the assignment guidelines:
    // Name:        <your name>
    // Class:       CS 3305/Section#
    // Term:        Fall 2026
    // Instructor:  Maxwell Bradley
    // Assignment:  1
    // IDE Name:    <your IDE name>

The rubric docks all points for a missing header, so this only checks that each
required field is present and filled in (not left as a placeholder) -- it does not
enforce specific values, since those can change per assignment/semester.
"""

import re
import sys
from pathlib import Path

CLASS_ROOT = Path(__file__).resolve().parent.parent
REQUIRED_FIELDS = ["Name", "Class", "Term", "Instructor", "Assignment", "IDE Name"]
HEADER_SCAN_LINES = 20

FIELD_PATTERN = re.compile(
    r"^\s*//\s*(" + "|".join(re.escape(f) for f in REQUIRED_FIELDS) + r")\s*:\s*(.*)$",
    re.IGNORECASE,
)
PLACEHOLDER_PATTERN = re.compile(r"^\s*<.*>\s*$")


def find_java_files(root: Path) -> list[Path]:
    return sorted(p for p in root.rglob("*.java") if ".ci" not in p.parts)


def check_file(path: Path) -> list[str]:
    lines = path.read_text(errors="replace").splitlines()[:HEADER_SCAN_LINES]

    found: dict[str, str] = {}
    for line in lines:
        m = FIELD_PATTERN.match(line)
        if m:
            key = m.group(1)
            # Normalize key casing/spacing to the canonical field name.
            canonical = next(f for f in REQUIRED_FIELDS if f.lower() == key.lower())
            found[canonical] = m.group(2).strip()

    problems = []
    for field in REQUIRED_FIELDS:
        value = found.get(field)
        if value is None:
            problems.append(f"missing '{field}:' line")
        elif not value or PLACEHOLDER_PATTERN.match(value):
            problems.append(f"'{field}:' is empty or still a placeholder")
    return problems


def main() -> int:
    java_files = find_java_files(CLASS_ROOT)
    if not java_files:
        print("No .java files found yet under Data-Structures-and-Algorithms -- nothing to check.")
        return 0

    failed = False
    for path in java_files:
        rel = path.relative_to(CLASS_ROOT)
        problems = check_file(path)
        if problems:
            failed = True
            print(f"FAIL {rel}")
            for p in problems:
                print(f"  - {p}")
        else:
            print(f"OK   {rel}")

    if failed:
        print("\nOne or more files are missing a complete author header.")
        print("Required header format:")
        print("  // Name:        <your name>")
        print("  // Class:       CS 3305/Section#")
        print("  // Term:        <term>")
        print("  // Instructor:  <instructor>")
        print("  // Assignment:  <number>")
        print("  // IDE Name:    <your IDE name>")
        return 1

    print("\nAll .java files have a complete author header.")
    return 0


if __name__ == "__main__":
    sys.exit(main())
