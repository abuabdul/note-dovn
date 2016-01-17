/*
 * Copyright 2013-2016 abuabdul.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */
package com.abuabdul.notedovn.util;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.newLinkedList;
import static java.util.Collections.sort;
import static org.apache.commons.lang3.StringUtils.isNotEmpty;
import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.LinkedList;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.abuabdul.notedovn.document.folder.NotesFolder;
import com.abuabdul.notedovn.document.model.ScratchNote;
import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;

/**
 * @author abuabdul
 *
 */
public class NoteDovnUtil {

	public static Date getUTCDateTime() {
		return new DateTime(DateTimeZone.UTC).toDate();
	}

	public static LinkedList<NotesFolder> wrapInFolder(LinkedList<ScratchNote> notes) {
		int size = notes.size();
		int folderSize = (size % 3) == 0 ? size / 3 : size / 3 + 1;
		LinkedList<NotesFolder> notesFolders = new LinkedList<>(new ArrayList<NotesFolder>(folderSize));
		if (!isEmpty(notes)) {
			notes = groupByCategoryOrDate(notes);
			for (int j = 0; j < folderSize; j++) {
				NotesFolder folder = new NotesFolder();
				for (int i = 1; i <= 3; i++) {
					folder.set(i, when(size - 1, notes));
					size--;
				}
				notesFolders.add(folder);
			}
		}
		return notesFolders;
	}

	public static ScratchNote when(int actual, LinkedList<ScratchNote> notes) {
		if (actual >= 0 && actual < notes.size()) {
			return notes.get(actual);
		}
		return new ScratchNote();
	}

	public static boolean isRestrictedField(String name) {
		if (isNotEmpty(name)) {
			return name.equalsIgnoreCase("aboutNote") ? true : name.equalsIgnoreCase("noteMsg") ? true : false;
		}
		return false;
	}

	public static LinkedList<ScratchNote> groupByCategoryOrDate(LinkedList<ScratchNote> notes) {
		LinkedList<ScratchNote> grpByCategory = filterAndSortByCategory(notes);
		LinkedList<ScratchNote> grpByUpdatedDate = filterAndSortByUpdatedDate(notes);
		LinkedList<ScratchNote> sortedLinkedList = newLinkedList(grpByUpdatedDate);
		sortedLinkedList.addAll(grpByCategory);
		return sortedLinkedList;
	}

	public static LinkedList<ScratchNote> filterAndSortByCategory(LinkedList<ScratchNote> notes) {
		if (!notes.isEmpty()) {
			LinkedList<ScratchNote> category = newLinkedList(filter(notes, categoryPredicate()));
			sort(category, categoryComparator());
			return category;
		}
		return notes;
	}

	public static LinkedList<ScratchNote> filterAndSortByUpdatedDate(LinkedList<ScratchNote> notes) {
		if (!notes.isEmpty()) {
			LinkedList<ScratchNote> updateDate = newLinkedList(filter(notes, categoryPredicateNulls()));
			sort(updateDate, updatedDateComparator());
			return updateDate;
		}
		return notes;
	}

	public static Predicate<ScratchNote> categoryPredicate() {
		return new Predicate<ScratchNote>() {
			@Override
			public boolean apply(ScratchNote input) {
				return StringUtils.isNotEmpty(input.getCategory());
			}
		};
	}

	public static Predicate<ScratchNote> categoryPredicateNulls() {
		return new Predicate<ScratchNote>() {
			@Override
			public boolean apply(ScratchNote input) {
				return StringUtils.isEmpty(input.getCategory());
			}
		};
	}

	private static Ordering<ScratchNote> orderingCategory = Ordering.natural().reverse()
			.onResultOf(new Function<ScratchNote, String>() {
				@Override
				public String apply(ScratchNote note) {
					return note.getCategory();
				}
			});

	public static Comparator<ScratchNote> categoryComparator() {
		return new Comparator<ScratchNote>() {
			@Override
			public int compare(ScratchNote n1, ScratchNote n2) {
				return orderingCategory.compare(n1, n2);
			}
		};
	}

	private static Ordering<ScratchNote> orderingUpdatedDate = Ordering.natural().reverse()
			.onResultOf(new Function<ScratchNote, Date>() {
				@Override
				public Date apply(ScratchNote note) {
					return note.getUpdatedDate();
				}
			});

	public static Comparator<ScratchNote> updatedDateComparator() {
		return new Comparator<ScratchNote>() {
			@Override
			public int compare(ScratchNote n1, ScratchNote n2) {
				return orderingUpdatedDate.compare(n1, n2);
			}
		};
	}
}
